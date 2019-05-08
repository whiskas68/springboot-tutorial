package com.whiskas68.booter.controller;

import com.whiskas68.booter.entity.User;
import com.whiskas68.booter.service.UserService;
import com.whiskas68.booter.util.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    //static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long,User>());
    //@RequestMapping(value = "/",method = RequestMethod.GET)
    //public List<User> getUserList(){
    //    User user = userService.getUsers();
    //    //List<User> r = new ArrayList<User>(users.values());
    //    return user;
    //}

    @GetMapping(value = "",produces = "application/json")
    public ResponseCode getUserAll(){
        List<User> list = new ArrayList<User>(userService.getUsers());
        logger.info("查询所有用户信息==>" + list);
        return ResponseCode.ok("查询成功",list);
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseCode getUser(@PathVariable Long id){
        logger.info("查询用户信息，查询用户ID为==> {}",id);
        //User user = userService.getUserById(id);
        User user = userService.getUserById(id);
        return ResponseCode.ok("查询成功",user);
        //return user;
    }
}
