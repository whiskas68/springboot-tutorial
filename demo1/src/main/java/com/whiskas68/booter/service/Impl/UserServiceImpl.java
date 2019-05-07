package com.whiskas68.booter.service.Impl;

import com.whiskas68.booter.entity.User;
import com.whiskas68.booter.mapper.UserMapper;
import com.whiskas68.booter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.selectAll();
    }

    public User getUserById(Long id){
        return userMapper.selectById(id);
    }

    public void add(User user){
        userMapper.insert(user);
    }

    public void edit(User user){
        userMapper.update(user);
    }

    public void remove(Long id){
        userMapper.delete(id);
    }

}
