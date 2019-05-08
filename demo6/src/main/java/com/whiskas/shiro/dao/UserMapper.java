package com.whiskas.shiro.dao;

import com.whiskas.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUserName(String userName);
}
