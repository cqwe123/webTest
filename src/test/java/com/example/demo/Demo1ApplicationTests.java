package com.example.demo;

import com.example.demo.demos.dao.Sutdent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    private Sutdent s;
    @Test
    void contextLoads() {
        System.out.println(s.getName());
        System.out.println(Demo1Application.class);
    }

}
