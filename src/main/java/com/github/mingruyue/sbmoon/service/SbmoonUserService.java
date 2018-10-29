package com.github.mingruyue.sbmoon.service;

import com.github.mingruyue.sbmoon.dao.SbmoonUserDao;
import com.github.mingruyue.sbmoon.domain.SbmoonUser;
import com.github.mingruyue.sbmoon.result.CodeMsg;
import com.github.mingruyue.sbmoon.util.MD5Util;
import com.github.mingruyue.sbmoon.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SbmoonUserService {

    private SbmoonUserDao sbmoonUserDao;

    @Autowired
    public SbmoonUserService(SbmoonUserDao sbmoonUserDao) {
        this.sbmoonUserDao = sbmoonUserDao;
    }


    public SbmoonUser getUserById(Long id) {
        return sbmoonUserDao.getById(id);
    }

    public CodeMsg login(LoginVo loginVo) {
        if (loginVo == null) {
            return CodeMsg.SERVER_ERROR;
        }
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        //判断手机号是否存在
        SbmoonUser user = getUserById(Long.parseLong(mobile));
        if (user == null) {
            return CodeMsg.MOBILE_NOT_EXIST;
        }

        //验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();
        String calcDbPass = MD5Util.formPass2DbPass(password, dbSalt);
        if (!calcDbPass.equals(dbPass)) {
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;
    }
}
