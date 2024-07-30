package com.example.demo.demos.service;

import com.example.demo.demos.utils.Result;


public interface EmployeeService {
    Result<org.example.Employee> getEmployeeById(String id);
}
