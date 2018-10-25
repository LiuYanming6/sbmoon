package com.github.mingruyue.sbmoon.redis;

public abstract class BasePrefix implements KeyPrefix{
    private int expireSeconds;
    private String prefix;

    public BasePrefix(String prefix) {
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    /**
     *
     * @return 默认0代表永不过期
     */
    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    /**
     * 不同模块前缀不同，这里我们用类名就可以了
     * @return 类名+prefix
     */
    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
