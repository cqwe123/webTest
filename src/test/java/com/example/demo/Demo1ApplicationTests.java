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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import static okhttp3.internal.Util.UTC;

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
//        CountDownLatch latch = new CountDownLatch(300);
//        Runnable task = ()->{
//            for (int i=0;i<100;i++){
//                Long id = redisIdWorker.nextId("order");
//                System.out.println("id = "+id);
//        }
//
//            latch.countDown ();
//        };
//        Long begin = System.currentTimeMillis();
//        for (int i=0;i<300;i++) {
//            es.submit(task);
//        }
//            latch.await();
//            Long end = System.currentTimeMillis();
//            System.out.println("time =" + (end -begin));
//距离原点一年
//        Date date = new Date(1000L * 60 * 60 * 24 * 365);
//        System.out.println(date);
//        System.out.println(date.getTime());
//        System.out.println(ZoneId.systemDefault());
//        System.out.println(ZoneId.getAvailableZoneIds().size()+" " +ZoneId.getAvailableZoneIds());
//        System.out.println(Instant.now());
//        redisIdWorker.nextId("order");
    }
}
