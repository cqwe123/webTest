package com.example.demo.demos.controller.loginController;

import com.example.demo.demos.config.JedisConnectionFactory;
import com.example.demo.demos.dao.Sutdent;
import com.example.demo.demos.exception.TestException;
import com.example.demo.demos.service.TestMysql;
import com.example.demo.demos.utils.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.example.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@RestController
@Api(tags = "git登录测试接口")
@Slf4j
public class login {
    @Autowired
    Sutdent sutdent;
    @Autowired
    TestMysql testMysql;
    @GetMapping("logins")
    public String login()
    {
        Jedis jedis = JedisConnectionFactory.getJedis();
        System.out.println(sutdent.toString());
        log.info("学生的信息是： {}",sutdent.toString());
       Sutdent sutdent1=new Sutdent();
       String a = jedis.get("name");
       if (jedis!=null)
           jedis.close();
        return a;
    }

    /**
     * @return {@link String }
     */
    @PostMapping("logins")
    public String login2()
    {
        return "hello! git logined post";
    }
  @PutMapping("logins")
    public String login4()
    {
        return "hello! git logined4222 put";
    }
    @DeleteMapping ("logins/{id}")
    public String login5(@PathVariable int id)
    {
        System.out.println(id);
        return "hello! git logined5";
    }
    @GetMapping("getInfo")
    public Employee getInfo()
    {
//        System.out.println(id);
        log.info("admin的信息为： {}",testMysql.getInfo());
        return testMysql.getInfo();
    }
    @GetMapping("getInfo2")
    public String getInfo2()
    {
//        System.out.println(id);
        log.info("admin的信息为： {}",testMysql.getInfo());
        Jedis jedis=new Jedis("192.168.31.136",6379);
        jedis.auth("160150..");
        return jedis.get("name");
    }
    @GetMapping("getInfo3")
    public Result getInfo3()
    {
        throw new TestException("测试异常");

    }

}
