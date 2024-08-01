package com.example.demo.demos.service.impl;

import com.alibaba.fastjson2.JSON;
import com.example.demo.demos.constant.ShopConstant;
import com.example.demo.demos.mapper.ShopMapShopMapper;
import com.example.demo.demos.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.example.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopMapShopMapper shopMapShopMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public Category getCategoryById(int id) {
        //缓存查询
        String shopCategory = stringRedisTemplate.opsForValue().get(ShopConstant.SHOP_CODE_PREFIX+id);
        //缓存命中
        if (shopCategory!=null){
            log.info("缓存命中到id为{}商品类别",id);
            return JSON.parseObject(shopCategory,Category.class);
        }
        //缓存未命中
        log.info("缓存未查询到id为{}商品类别",id);
        Category category = null;
        if (tryLock(id)){
            //模拟重建热点缓存延时
            log.info("id{}:商品类别正在重建",id);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //数据库查询
            category = shopMapShopMapper.selectById(id);
            //数据库未命中
            if (category == null){
                log.info("数据库未查询到id为{}商品类别",id);
            }
            //数据库命中
            else {
                log.info("数据库查询到商品类别为: {}",category);
                //查询到后加锁并构建热点商品缓存

                stringRedisTemplate.opsForValue().setIfAbsent(ShopConstant.SHOP_CODE_PREFIX+id,
                        JSON.toJSONString(category));
                log.info("释放锁");
                stringRedisTemplate.delete(ShopConstant.SHOP_CODE_PREFIX_LOCK+id);
            }
        }else{
            log.info("id{}： 商品类别正在重建",id);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getCategoryById(id);
        }
        return category;
    }
    public Boolean tryLock(int id){
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(ShopConstant.SHOP_CODE_PREFIX_LOCK+id ,
                "1",ShopConstant.SHOP_CODE_TIMEOUT, TimeUnit.SECONDS);
        return flag;

    }
}
