package com.example.demo.demos.controller.loginController;

import com.example.demo.demos.dao.Sutdent;
import com.example.demo.demos.service.TestMysql;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.example.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "git登录测试接口")
@Slf4j
public class login {
    @Autowired
    Sutdent sutdent;
    @Autowired
    TestMysql testMysql;
    @GetMapping("logins")
    public String login()
    {
        System.out.println(sutdent.toString());
        log.info("学生的信息是： {}",sutdent.toString());
        return "hello! git logined get";
    }

    /**
     * @return {@link String }
     */
    @PostMapping("logins")
    public String login2()
    {
        return "hello! git logined post";
    }
  @PutMapping("logins")
    public String login4()
    {
        return "hello! git logined4222 put";
    }
    @DeleteMapping ("logins/{id}")
    public String login5(@PathVariable int id)
    {
        System.out.println(id);
        return "hello! git logined5";
    }
    @GetMapping("getInfo")
    public Employee getInfo()
    {
//        System.out.println(id);
        log.info("admin的信息为： {}",testMysql.getInfo());
        return testMysql.getInfo();
    }
}
