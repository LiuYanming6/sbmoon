package com.github.mingruyue.sbmoon.result;

public class CodeMsg {
    private int code;
    private String msg;

    //通用模块
    public static final CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static final CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器异常");

    //登陆模块 5002XX, 因为前端 js 控制, 正常情况下不可能为空
    public static final CodeMsg MOBILE_EMPTY = new CodeMsg(500210, "手机号不能为空");
    public static final CodeMsg MOBILE_ERROR = new CodeMsg(500211, "手机号格式不对");
    public static final CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500212, "手机号不存在");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(500213, "密码错误");
    public static final CodeMsg PASSWORD_EMPTY = new CodeMsg(500214, "密码不能为空");

    //其它模块


    private CodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
