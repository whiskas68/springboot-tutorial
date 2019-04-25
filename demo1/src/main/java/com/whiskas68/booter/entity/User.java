package com.whiskas68.booter.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
}
