package com.whiskas68.ioc.service;

import com.whiskas68.ioc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    public void printUser(User user){
        log.info("这是一个Service类");

    }

}
