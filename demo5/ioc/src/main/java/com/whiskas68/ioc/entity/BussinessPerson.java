package com.whiskas68.ioc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BussinessPerson implements Person {

    @Autowired
    private Computer computer;

    @Override
    public void service(){
        this.computer.surfInternet();
    }

}
