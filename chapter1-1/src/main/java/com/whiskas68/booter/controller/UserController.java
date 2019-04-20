package com.whiskas68.booter.controller;

import com.whiskas68.booter.entity.User;
import com.whiskas68.booter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    //static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long,User>());

    //@RequestMapping(value = "/",method = RequestMethod.GET)
    //public List<User> getUserList(){
    //    User user = userService.getUsers();
    //    //List<User> r = new ArrayList<User>(users.values());
    //    return user;
    //}

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        return user;
    }
}
