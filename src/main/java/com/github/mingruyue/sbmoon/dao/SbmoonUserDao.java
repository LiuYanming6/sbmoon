package com.github.mingruyue.sbmoon.dao;

import com.github.mingruyue.sbmoon.domain.SbmoonUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SbmoonUserDao {

    @Select("select * from sbmoon_user where id = #{id}")
    SbmoonUser getById(@Param("id") long id);
}
