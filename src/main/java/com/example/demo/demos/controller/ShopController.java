package com.example.demo.demos.controller;


import com.example.demo.demos.service.impl.ShopServiceImpl;
import com.example.demo.demos.utils.Result;
import org.example.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    @Autowired
    private ShopServiceImpl shopSeiviceImpl;
    @GetMapping("getCategoryById/{id}")
    public Result<Category> getCategoryById(@PathVariable int id){
        Category category = shopSeiviceImpl.getCategoryById(id);
        if (category != null){
            return Result.ok(category);
        }
        return Result.error("商品不存在!");
    }
}
