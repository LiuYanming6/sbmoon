package com.github.mingruyue.sbmoon.redis;
/*
模板模式
接口 - 定义锲约
抽象类 - 实现通用方法
具体类
description 不同的模块将有不同的前缀
 */
public interface KeyPrefix {
    int expireSeconds();
    String getPrefix();
}
