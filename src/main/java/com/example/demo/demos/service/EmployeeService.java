package com.example.demo.demos.service;

import com.example.demo.demos.utils.Result;
import org.example.Employee;


public interface EmployeeService {
    Result<Employee> getEmployeeById(String id);
     boolean updateEmployeeById(Employee employee);
}
