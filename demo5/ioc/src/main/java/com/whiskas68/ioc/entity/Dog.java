package com.whiskas68.ioc.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Dog implements Animal {

    @Override
    public void use(){
        log.info(Dog.class.getSimpleName() + "会看门");
    }
}
