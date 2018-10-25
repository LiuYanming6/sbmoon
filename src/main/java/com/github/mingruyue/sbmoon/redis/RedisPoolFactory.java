package com.github.mingruyue.sbmoon.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/*
The dependencies of some of the beans in the application context form a cycle:

   dbController (field com.github.mingruyue.sbmoon.redis.RedisService com.github.mingruyue.sbmoon.controller.DbController.redisService)
┌─────┐
|  redisService defined in file [C:\Users\liuya\IdeaProjects\sbmoon\sbmoon\target\classes\com\github\mingruyue\sbmoon\redis\RedisService.class]
└─────┘
下面的代码放在RedisService时会造成上面的错误，循环引用
 */
@Service  //如果没有这个注解的话 报Consider defining a bean of type 'redis.clients.jedis.JedisPool' in your configuration.
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    /*
    https://github.com/xetorthio/jedis/wiki/Getting-started
    JedisPool 适用于多线程环境，线程安全，并且可以获得很好的性能
     */
    @Bean
    public JedisPool JedisPoolFactory() {
//        System.out.println(redisConfig.getPoolMaxTotal());
//        System.out.println(redisConfig.getPoolMaxIdle());
//        System.out.println(redisConfig.getPoolMaxWait());
//        System.out.println(redisConfig.getHost());
//        System.out.println(redisConfig.getPort());
//        System.out.println(redisConfig.getTimeout());
//        System.out.println(redisConfig.getPassword());
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
////        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
////        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
////        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait());
//        return new JedisPool(poolConfig,
//                redisConfig.getHost(),
//                redisConfig.getPort(),
//                redisConfig.getTimeout(),
//                redisConfig.getPassword());

        return new JedisPool(new JedisPoolConfig(),
                redisConfig.getHost(),
                redisConfig.getPort(),
                redisConfig.getTimeout(),
                redisConfig.getPassword());
    }
}
