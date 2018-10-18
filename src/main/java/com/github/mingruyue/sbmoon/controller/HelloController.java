package com.github.mingruyue.sbmoon.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.mingruyue.sbmoon.result.CodeMsg;
import com.github.mingruyue.sbmoon.result.Result;
//import jdk.jfr.Enabled;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping("demo")
public class HelloController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("hello")
    public Result<String> hello() {
        return Result.success("这是用户数据");
    }

    @RequestMapping("helloError")
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }
}
