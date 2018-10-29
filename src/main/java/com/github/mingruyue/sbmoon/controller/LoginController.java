package com.github.mingruyue.sbmoon.controller;

import com.github.mingruyue.sbmoon.redis.RedisService;
import com.github.mingruyue.sbmoon.result.CodeMsg;
import com.github.mingruyue.sbmoon.result.Result;
import com.github.mingruyue.sbmoon.service.SbmoonUserService;
import com.github.mingruyue.sbmoon.util.MD5Util;
import com.github.mingruyue.sbmoon.util.ValidatorUtil;
import com.github.mingruyue.sbmoon.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

@Controller
@RequestMapping("login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private SbmoonUserService sbmoonUserService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(LoginVo vo) {
        log.info(vo.toString());

        //参数校验
        String mobile = vo.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }

        String password = vo.getPassword();
        if (StringUtils.isEmpty(password) || password.equals(MD5Util.getNullMd5())) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if (!ValidatorUtil.isMobile(mobile)) {
            return Result.error(CodeMsg.MOBILE_ERROR);
        }

        CodeMsg codeMsg = sbmoonUserService.login(vo);
        if (codeMsg.getCode() == 0) {
            return Result.success(true);
        } else {
            return Result.error(codeMsg);
        }
    }
}
