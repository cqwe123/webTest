package com.example.demo.demos.controller.loginController;

import com.example.demo.demos.dao.Sutdent;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "git登录测试接口")
@Slf4j
public class login {
    @Autowired
    Sutdent sutdent;
    @GetMapping("logins")
    public String login()
    {
        System.out.println(sutdent.toString());
        log.info("学生的信息是： {}",sutdent.toString());
        return "hello! git logined get";
    }

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
}
