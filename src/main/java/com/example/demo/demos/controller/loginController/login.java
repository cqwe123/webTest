package com.example.demo.demos.controller.loginController;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "git登录测试接口")
public class login {
    @GetMapping("login")
    public String login()
    {
        return "hello! git logined";
    }

    @GetMapping("login2")
    public String login2()
    {
        return "hello! git logined2";
    }
    @GetMapping("login3")
    public String login3()
    {
        return "hello! git logined3";
    }
    @GetMapping("login4222")
    public String login4()
    {
        return "hello! git logined4222";
    }
    @GetMapping("login5")
    public String login5()
    {
        return "hello! git logined5";
    }
}
