package com.whiskas68.booter.service.Impl;

import com.whiskas68.booter.entity.Department;
import com.whiskas68.booter.mapper.oa.DepartmentMapper;
import com.whiskas68.booter.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepartment(){
        return departmentMapper.selectAll();
    }

    public Department getDepartmentBySn(String sn){
        return departmentMapper.selectBySn(sn);
    }

}
