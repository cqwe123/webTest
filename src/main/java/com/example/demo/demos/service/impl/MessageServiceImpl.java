package com.example.demo.demos.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.example.demo.demos.constant.SmsConstant;
import com.example.demo.demos.service.MessageService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private SmsConstant smsConstant;
   public String requestCode(String telephone)  {
       Config config = new Config()
               // 您的AccessKey ID
               .setAccessKeyId(smsConstant.getSMS_ACCESS_KEY_ID())
               // 您的AccessKey Secret
               .setAccessKeySecret(smsConstant.getACCESS_KEY_SECRET());
// 访问的域名
       config.endpoint = "dysmsapi.aliyuncs.com";
       Client client = null;
       try {
           client = new Client(config);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       SendSmsRequest request = new SendSmsRequest();

       request.phoneNumbers = telephone; // 该参数值为假设值，请您根据实际情况进行填写

       request.signName = smsConstant.getSIGN_NAME(); // 该参数值为假设值，请您根据实际情况进行填写
       request.setTemplateCode(smsConstant.getTEMP_LATE_CODE());
       Random random = new Random();
       // 生成一个四位数的验证码
       int verificationCode = 1000 + random.nextInt(9000);
       //将数字转为字符串
       String  code = verificationCode + "";
       request.setTemplateParam("{\"code\":\"" + code + "\"}");
       SendSmsResponse response = null;
       try {
           response = client.sendSms(request);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       System.out.println(new Gson().toJson(response.body));
       String requestId = response.body.requestId;
       return code;
   }
}
