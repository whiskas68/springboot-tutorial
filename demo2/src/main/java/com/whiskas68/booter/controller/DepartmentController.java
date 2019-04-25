package com.whiskas68.booter.controller;

import com.whiskas68.booter.entity.Department;
import com.whiskas68.booter.entity.User;
import com.whiskas68.booter.service.DepartmentService;
import com.whiskas68.booter.service.UserService;
import com.whiskas68.booter.util.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DepartmentService departmentService;

    //static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long,User>());
    //@RequestMapping(value = "/",method = RequestMethod.GET)
    //public List<User> getUserList(){
    //    User user = userService.getUsers();
    //    //List<User> r = new ArrayList<User>(users.values());
    //    return user;
    //}

    @GetMapping(value = "",produces = "application/json")
    public ResponseCode getDepartmentAll(){
        logger.info("查询所有用户信息==>");
        List<Department> list = new ArrayList<Department>(departmentService.getDepartment());
        return ResponseCode.ok("查询成功",list);
    }

    @GetMapping(value = "/{sn}",produces = "application/json")
    public ResponseCode getDepartment(@PathVariable String sn){
        logger.info("查询用户信息，查询用户ID为==> {}",sn);
        //User user = userService.getUserById(id);
        Department department = departmentService.getDepartmentBySn(sn);
        return ResponseCode.ok("查询成功",department);
        //return user;
    }
}
