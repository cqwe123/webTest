package com.example.demo.demos.controller;

import com.example.demo.demos.service.impl.EmployeeServiceImpl;
import com.example.demo.demos.utils.Result;
import org.example.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeImpl;
    @GetMapping("getEmployeeById/{id}")
    public Result<Employee> getEmployeeById(@PathVariable String id){

        return employeeImpl.getEmployeeById(id);
    }
}
