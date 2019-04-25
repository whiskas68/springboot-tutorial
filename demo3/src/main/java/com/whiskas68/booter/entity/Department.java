package com.whiskas68.booter.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Department implements Serializable {
    private String sn;
    private String name;
    private String address;
}
