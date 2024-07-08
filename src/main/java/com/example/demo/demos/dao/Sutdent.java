package com.example.demo.demos.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 *
 * @author ccc23
 * @date 2024/07/08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "student")
public class Sutdent {
    /**
     * 名称
     */
    String name;
    int age;
    /**
     * 性别
     */
    @Value("${student.gender}")
    String sex;
    /**
     * 住址
     */
    String address;
    /**
     * 电话
     */
    String Telephone;
}
