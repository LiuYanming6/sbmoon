package com.github.mingruyue.sbmoon.service;

import com.github.mingruyue.sbmoon.dao.UserDao;
import com.github.mingruyue.sbmoon.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getById(int id){
        return userDao.getById(id);
    }


//  事务一致性 这个注释保证所有插入要么都成功要么都失败
    @Transactional
    public boolean tx(){
        //成功
        User u1 = new User();
        u1.setId(2);
        u1.setName("222");
        userDao.insert(u1);

        //失败
        User u2 = new User();
        u2.setId(1);
        u2.setName("333");
        userDao.insert(u2);

        return true;
    }

    //只是为了使测试测试
    public String greet() {
        return "He He";
    }
}
