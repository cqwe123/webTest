package com.example.demo.demos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class login {
    @GetMapping("login")
    public String login()
    {
        return "hello! git logined";
    }
}
