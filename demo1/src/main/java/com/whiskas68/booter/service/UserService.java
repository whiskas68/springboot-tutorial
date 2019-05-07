package com.whiskas68.booter.service;

import com.whiskas68.booter.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long id);
    void add(User user);
}
