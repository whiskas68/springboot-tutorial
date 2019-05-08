package com.whiskas.shiro.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private static final long serialVersionUID = -5440372534300871944L;

    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private String status;
}
