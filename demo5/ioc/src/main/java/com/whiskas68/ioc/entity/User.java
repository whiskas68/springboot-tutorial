package com.whiskas68.ioc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@Component("user")
public class User implements Serializable {

    @Value("1")
    private Long id;

    @Value("whiskas68")
    private String name;

    @Value("管理员")
    private String desc;
}
