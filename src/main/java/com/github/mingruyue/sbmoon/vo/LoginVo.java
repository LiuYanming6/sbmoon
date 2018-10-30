package com.github.mingruyue.sbmoon.vo;

import com.github.mingruyue.sbmoon.validator.IsMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/*
VO
接收 login 的 post 参数
jsr303校验
 */
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min = 8)
    private String password;

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
