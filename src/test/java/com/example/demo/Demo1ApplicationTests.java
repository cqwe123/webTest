package com.example.demo;

import com.example.demo.demos.constant.Sms;
import com.example.demo.demos.dao.Sutdent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {
//    @Autowired
//    private Sutdent s;
    @Autowired
    private Sms sms;
    @Test
    void contextLoads() {
//        Sms sms = new Sms();
        System.out.println(sms.getSMS_ACCESS_KEY_ID());
    }

}
