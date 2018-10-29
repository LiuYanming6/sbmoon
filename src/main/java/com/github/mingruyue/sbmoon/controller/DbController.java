package com.github.mingruyue.sbmoon.controller;

import com.github.mingruyue.sbmoon.domain.User;
import com.github.mingruyue.sbmoon.redis.RedisService;
import com.github.mingruyue.sbmoon.redis.UserKey;
import com.github.mingruyue.sbmoon.result.Result;
import com.github.mingruyue.sbmoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DbController {
    private final UserService userService;

    private final RedisService redisService;

    @Autowired
    public DbController(UserService userService, RedisService redisService) {
        this.userService = userService;
        this.redisService = redisService;
    }

    //只是为了使测试测试
    @RequestMapping("/greet")
    public @ResponseBody
    String greeting() {
        return userService.greet();
    }

    @RequestMapping("get")
    @ResponseBody
    public Result<User> getUser(){
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Long> redisGet(){
        Long v1 = redisService.get(null,"key1", Long.class);
        return Result.success(v1);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<String> redisSet(){
        User user = new User();
        user.setId(1);
        user.setName("jackliu");
        redisService.set(UserKey.getById, ""+user.getId() ,user.getName());

        // test use
        String name = redisService.get(UserKey.getById, ""+user.getId(), String.class);
//        User u1 = new User();
//        u1.setId(user.getId());
//        u1.setName(name);
        System.out.println(name);
        return Result.success(name);
    }
}
