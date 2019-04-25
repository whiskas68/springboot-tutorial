package com.whiskas68.booter.mapper.shop;

import com.whiskas68.booter.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {

    List<User> selectAll();

    User selectById(Long id);
}
