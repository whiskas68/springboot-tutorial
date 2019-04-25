package com.whiskas68.booter.mapper.oa;

import com.whiskas68.booter.entity.Department;
import com.whiskas68.booter.entity.User;

import java.util.List;


public interface DepartmentMapper {

    List<Department> selectAll();

    Department selectBySn(String sn);
}
