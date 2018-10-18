package com.github.mingruyue.sbmoon.dao;

import com.github.mingruyue.sbmoon.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
//操作数据库
@Mapper
public interface UserDao {
    @Select("select * from user where id  = #{id}")
    User getById(@Param("id") int id);

    @Insert("insert int user(name) values(#{name})")
    int insert(User user);
}
