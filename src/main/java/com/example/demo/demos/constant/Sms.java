package com.example.demo.demos.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//SMS 是Short Message Service（短消息服务）的缩写
@Data
@Component
public class Sms {
    @Value("${SMS.accessKeyId}")
    private  String SMS_ACCESS_KEY_ID;
    @Value("${SMS.AccessKeySecret}")
    private  String ACCESS_KEY_SECRET;
    @Value("${SMS.SIGN_NAME}")
    private  String SIGN_NAME;
    @Value("${SMS.TEMP_LATE_CODE}")
    private  String TEMP_LATE_CODE;



}
