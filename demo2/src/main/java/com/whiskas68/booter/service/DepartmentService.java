package com.whiskas68.booter.service;

import com.whiskas68.booter.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartment();
    Department getDepartmentBySn(String sn);
}
