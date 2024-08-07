package com.example.demo.demos.controller;

import com.example.demo.demos.service.VoucherService;
import com.example.demo.demos.utils.Result;
import org.example.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;
    @PostMapping("/seckill")
    public Result<Long> voucher(@RequestBody Voucher voucher){
        voucherService.addSeckillVoucher(voucher);
        return Result.ok(voucher.getId());
    }
    @PostMapping("/seckill-order/{id}")
    public Result seckillVoucherOrder(@PathVariable Long id){
        return Result.error("暂未开放");
    }
}
