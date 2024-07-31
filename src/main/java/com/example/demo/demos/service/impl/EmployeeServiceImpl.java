package com.example.demo.demos.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        String employee = stringRedisTemplate.opsForValue().get(EmployeeConstant.NAME_PRE + id);
        Employee employee1 = null;
        //缓存没命中,去数据库取
        if(employee == null){
            log.info("缓存未命中");
            employee1 = employeeMapper.selectById(id);
        }else{
            //缓存命中,直接返回
            log.info("缓存命中 所查询用户id:"+id);
            return Result.ok(JSON.parseObject(employee,Employee.class));
        }
        //数据库没有取到,直接返回
        if (employee1 == null){
            log.info("数据库未命中");
            return Result.error("没有找到该员工");
        }else {
            //数据库取到后写入缓存,并返回结果
            log.info("数据库命中");
            stringRedisTemplate.opsForValue().set(EmployeeConstant.NAME_PRE + id,
                    JSON.toJSONString(employee1),EmployeeConstant.TIMEOUT, TimeUnit.MINUTES);
            return Result.ok(employee1);
        }
    }

    @Transactional
    public boolean updateEmployeeById(Employee employee) {
        employee.setUpdateTime(LocalDateTime.now());
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",employee.getId());
        updateWrapper.set("update_time",LocalDateTime.now());
        updateWrapper.set("name",employee.getName());
        updateWrapper.set("sex",employee.getSex());
        updateWrapper.set("phone",employee.getPhone());
        updateWrapper.set("id_number",employee.getIdNumber());
        updateWrapper.set("status",employee.getStatus());
        updateWrapper.set("username",employee.getUsername());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setUpdateUser(employee.getId());
        int updateNum = employeeMapper.update(null,updateWrapper);
       if (updateNum > 0)
       {
           stringRedisTemplate.delete(EmployeeConstant.NAME_PRE + employee.getId());
           return true;
       }
      return false;

    }
}
