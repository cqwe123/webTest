package com.example.demo;

import com.example.demo.demos.constant.SmsConstant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {
//    @Autowired
//    private Sutdent s;
    @Autowired
    private SmsConstant smsConstant;
    @Test
    void contextLoads() {
//        Sms sms = new Sms();
        System.out.println(smsConstant.getSMS_ACCESS_KEY_ID());
    }

}
