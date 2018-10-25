package com.github.mingruyue.sbmoon.redis;

public class UserKey extends BasePrefix {

    // private 防止被实例化
    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
