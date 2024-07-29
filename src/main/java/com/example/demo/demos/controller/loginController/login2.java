package com.example.demo.demos.controller.loginController;


import com.example.demo.demos.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class login2 {
    @GetMapping("login")
    public Result login() {
        return Result.ok();
    }
}
