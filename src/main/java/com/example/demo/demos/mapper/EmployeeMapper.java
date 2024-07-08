package com.example.demo.demos.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.Employee;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where username=#{username}")
    public Employee getInfo(String username);
}
