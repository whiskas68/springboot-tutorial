package com.whiskas68.ioc.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Computer implements Machine {

    public void surfInternet(){
        log.info(Computer.class.getSimpleName() + " 可以上网");
    }
}
