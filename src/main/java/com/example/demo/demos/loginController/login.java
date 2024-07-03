package com.example.demo.demos.loginController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    @GetMapping("login4")
    public String login4()
    {
        return "hello! git logined4";
    }
}
