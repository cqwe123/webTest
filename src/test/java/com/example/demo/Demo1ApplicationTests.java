package com.example.demo;

import com.example.demo.demos.constant.SmsConstant;
import com.example.demo.demos.mapper.EmployeeMapper;
import com.example.demo.demos.service.EmployeeService;
import com.example.demo.demos.utils.RedisIdWorker;
import com.example.demo.demos.utils.Result;
import org.example.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@SpringBootTest
class Demo1ApplicationTests {
//    @Autowired
//    private Sutdent s;
    @Autowired
    private SmsConstant smsConstant;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final long BEGIN_TIMESTAMP = 1723026452;
    @Autowired
    private RedisIdWorker redisIdWorker;
    private ExecutorService es = Executors.newFixedThreadPool(500);

    @Test
    void contextLoads() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(300);
        Runnable task = ()->{
            for (int i=0;i<100;i++){
                Long id = redisIdWorker.nextId("order");
                System.out.println("id = "+id);
        }

            latch.countDown ();
        };
        Long begin = System.currentTimeMillis();
        for (int i=0;i<300;i++) {
            es.submit(task);
        }
            latch.await();
            Long end = System.currentTimeMillis();
            System.out.println("time =" + (end -begin));


        }
}
