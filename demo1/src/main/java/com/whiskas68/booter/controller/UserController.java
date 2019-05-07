package com.whiskas68.booter.controller;

import com.whiskas68.booter.entity.User;
import com.whiskas68.booter.service.UserService;
import com.whiskas68.booter.util.ResponseCode;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获取用户列表", notes="")
    @GetMapping(value = "",produces = "application/json")
    public ResponseCode getUserAll(){
        logger.info("查询所有用户信息==>");
        List<User> list = new ArrayList<User>(userService.getUsers());
        return ResponseCode.ok("查询成功",list);
    }

    @ApiOperation(value = "获取用户详细信息",notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name="id",value="用户ID",required = true,dataType = "Long")
    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseCode getUser(@PathVariable Long id){
        logger.info("查询用户信息，查询用户ID为==> {}",id);
        User user = userService.getUserById(id);
        return ResponseCode.ok("查询成功",user);
    }

    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户")
    @ApiImplicitParam(name="user", value = "用户详细实体user",required = true,dataType = "User")
    @PutMapping(value ="/add",produces = "application/json")
    public ResponseCode addUser(@PathVariable User user){
        User auser = new User;

        logger.info("新增用户: ",user);
        userService.add(user);
        return ResponseCode.ok("创建成功",user);
    }


}
