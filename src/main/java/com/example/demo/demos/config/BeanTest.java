package com.example.demo.demos.config;

import com.example.demo.demos.dao.Sutdent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanTest {
    @Bean
    public Sutdent BeanTest() {
        System.out.println("BeanTest");
        return new Sutdent();
    }
}
