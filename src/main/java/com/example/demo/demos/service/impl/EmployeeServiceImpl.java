package com.example.demo.demos.service.impl;

import com.alibaba.fastjson2.JSON;
import com.example.demo.demos.constant.EmployeeConstant;
import com.example.demo.demos.mapper.EmployeeMapper;
import com.example.demo.demos.service.EmployeeService;
import com.example.demo.demos.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.example.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Result<Employee> getEmployeeById(String id) {
        //从缓存获取用户信息
        String employee = stringRedisTemplate.opsForValue().get(EmployeeConstant.namePre + id);
        Employee employee1 = null;
        //缓存没命中,去数据库取
        if(employee == null){
            log.info("缓存未命中");
            employee1 = employeeMapper.selectById(id);
        }else{
            //缓存命中,直接返回
            log.info("缓存命中");
            return Result.ok(JSON.parseObject(employee,Employee.class));
        }
        //数据库没有取到,直接返回
        if (employee1 == null){
            log.info("数据库未命中");
            return Result.error("没有找到该员工");
        }else {
            //数据库取到后写入缓存,并返回结果
            log.info("数据库命中");
            stringRedisTemplate.opsForValue().set(String.valueOf(EmployeeConstant.namePre + id),JSON.toJSONString(employee1),24, TimeUnit.HOURS);
            return Result.ok(employee1);
        }
    }
}
