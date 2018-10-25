package com.github.mingruyue.sbmoon.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*
Jedis jedis = new Jedis("localhost");
jedis.set("foo", "bar");
String value = jedis.get("foo");
官网上是这种用法,但我们用的是连接池
 */
@Service
public class RedisService {

    final
    JedisPool jedisPool;

    @Autowired
    public RedisService(JedisPool jedisPool, RedisConfig redisConfig) {
        this.jedisPool = jedisPool;
    }

    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = null;
            if (keyPrefix != null) realKey = keyPrefix.getPrefix() + key;
            else realKey = key;

            System.out.println(realKey);
            String str = jedis.get(realKey);
            T t = stringToBean(str, clazz);
            return t;
        } finally {
            //连接池记得关闭，不然后面可能就不够用了
            if (jedis != null) {
                //看源码进去，实际上是还到连接池里了
                jedis.close();
            }
        }
    }

    public <T> boolean set(KeyPrefix keyPrefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            String str = beanToString(value);
            int seconds = keyPrefix.expireSeconds();
            if (seconds <= 0) {
                jedis.set(realKey, str);
            }else{
                jedis.setex(realKey, seconds, str);
            }
            return true;
        } finally {
            //连接池记得关闭，不然后面可能就不够用了
            if (jedis != null) {
                //看源码进去，实际上是还到连接池里了
                jedis.close();
            }
        }
    }

    public boolean exists(KeyPrefix keyPrefix, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            String realKey = keyPrefix.getPrefix() + key;
            return jedis.exists(realKey);
        }finally {
            jedis.close();
        }
    }

    private <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    private <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            //Integer.parseInt(str) 返回的是int
            return (T) Integer.valueOf(str);
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else {
            return JSON.parseObject(str, clazz);
        }

    }

}
