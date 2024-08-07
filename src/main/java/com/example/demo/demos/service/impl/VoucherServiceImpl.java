package com.example.demo.demos.service.impl;

import com.example.demo.demos.mapper.SecKillVoucherMapper;
import com.example.demo.demos.mapper.VoucherMapper;
import com.example.demo.demos.service.VoucherService;
import com.example.demo.demos.utils.RedisIdWorker;
import org.example.SecKillVoucher;
import org.example.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherMapper voucherMapper;
    @Autowired
    private SecKillVoucherMapper secKillVoucherMapper;
    @Autowired
    private RedisIdWorker redisIdWorker;
    @Transactional
    @Override
    public void addSeckillVoucher(Voucher voucher) {
        voucher.setCreateTime(LocalDateTime.now());
        voucher.setUpdateTime(LocalDateTime.now());
        voucher.setId(redisIdWorker.nextId("voucher"));
        System.out.println(voucherMapper.insert(voucher));
        SecKillVoucher secKillVoucher = new SecKillVoucher();
        secKillVoucher.setVoucherId(voucher.getId());
        secKillVoucher.setStock(voucher.getStock());
        secKillVoucher.setBeginTime(voucher.getBeginTime());
        secKillVoucher.setEndTime(voucher.getEndTime());
        secKillVoucher.setUpdateTime(LocalDateTime.now());
        secKillVoucher.setCreateTime(LocalDateTime.now());

        secKillVoucherMapper.insert(secKillVoucher);
    }
}
