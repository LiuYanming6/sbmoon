package com.github.mingruyue.sbmoon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thyme")
public class ThymeController {
    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("name", "刘艳明");
        return "hello";
    }
}
