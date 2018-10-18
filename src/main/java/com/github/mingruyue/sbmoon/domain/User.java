package com.github.mingruyue.sbmoon.domain;

//返回给页面会用到这里的get方法
public class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return "扭轱辘" + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
