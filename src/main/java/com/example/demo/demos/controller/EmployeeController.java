package com.example.demo.demos.controller;

import com.example.demo.demos.service.impl.EmployeeServiceImpl;
import com.example.demo.demos.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.example.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeImpl;
    @GetMapping("getEmployeeById/{id}")
    public Result<Employee> getEmployeeById(@PathVariable String id){

        return employeeImpl.getEmployeeById(id);
    }
    @PutMapping("updateEmployeeById")
    public Result<Employee> updateEmployeeById(@RequestBody Employee employee){
        boolean flag = employeeImpl.updateEmployeeById(employee);
        if (flag){
            log.info("更新员工信息成功,缓存已删除");
            return Result.ok("更新员工信息成功");
        }
        return Result.error("更新失败");
    }
}
