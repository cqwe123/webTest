package com.example.demo.demos.service;

import com.example.demo.demos.utils.Result;
import org.example.Employee;


public interface EmployeeService {
    Result<org.example.Employee> getEmployeeById(String id);
    public boolean updateEmployeeById(Employee employee);
}
