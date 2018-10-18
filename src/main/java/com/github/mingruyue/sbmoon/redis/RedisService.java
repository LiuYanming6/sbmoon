package com.github.mingruyue.sbmoon.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @Autowired
    JedisPool jedisPool;

    public <T> T get(){
        Jedis jedis = jedisPool.getResource();
    }

    @Bean
    public JedisPool JedisFactory(){

    }
}
