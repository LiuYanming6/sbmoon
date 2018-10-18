package com.github.mingruyue.sbmoon.result;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    /*
    每一次犯错都是一次进步
    objects can be automatically converted to JSON
    上面的功能是由这里的get方法实现的，缺少的话，就不能转变成json
     */
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public Result(CodeMsg cm) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }

    /**
     * 返回正确, 包括用户请求数据
     *
     * @param data 返回给用户的数据
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    /**
     * 返回错误信息
     *
     * @param cm 错误信息
     */
    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<T>(cm);
    }
}
