package com.github.mingruyue.sbmoon.util;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    private static final Pattern mobile_pattern = Pattern.compile("1[\\d]{10}");

    public static boolean isMobile(String src) {
        if (StringUtils.isEmpty(src))
            return false;
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }

    public static void main(String[] args) {
        /*
        RegexBuddy 学习理解测试正则表达式的工具
         */
        System.out.println(isMobile("1234556"));
        System.out.println(isMobile("12345e78901"));
        System.out.println(isMobile("17621967096"));
    }
}
