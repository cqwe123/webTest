package com.example.demo.demos.controller.loginController;


import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.example.demo.demos.constant.Sms;
import com.example.demo.demos.service.Message;
import com.example.demo.demos.service.impl.MessageImpl;
import com.example.demo.demos.utils.Result;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class login2 {
    @Autowired
    private Message message;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("loginByTelephone/{telephone}/{code}")
    public Result loginByTelephone(@PathVariable String telephone,@PathVariable String code) {
        String myCode = stringRedisTemplate.opsForValue().get(telephone);
         log.info("myCode = {}", myCode);
        if (myCode == null)
            return Result.ok("手机号不存在或验证码过期");
        if (myCode.equals(code))
        return Result.ok("登录成功");
        else
            return Result.error("验证码错误");
    }
    @GetMapping("register/{telephone}")
    public Result register(@PathVariable String telephone) {
       String code = message.requestCode(telephone);
        stringRedisTemplate.opsForValue().set(telephone,code);
        stringRedisTemplate.opsForValue().getAndExpire(telephone, Duration.ofMinutes(5));
        return Result.ok();
    }

}
