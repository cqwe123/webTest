package com.example.demo.demos.service;

import com.example.demo.demos.mapper.EmployeeMapper;
import org.example.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMysql {
    @Autowired
    EmployeeMapper employeeService;

    public  Employee getInfo() {return employeeService.getInfo("admin");
    }
}
