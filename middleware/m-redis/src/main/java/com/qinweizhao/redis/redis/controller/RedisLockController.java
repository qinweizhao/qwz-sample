package com.qinweizhao.redis.redis.controller;

import com.qinweizhao.redis.redis.service.RedisLockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 * @since 2022/5/17
 */
@RestController
public class RedisLockController {

    @Resource
    RedisLockService redisLockService;


    @GetMapping("/lock1")
    public Object lock1() {
        return redisLockService.lock1();
    }

    @GetMapping("/lock2")
    public Object lock2() {
        return redisLockService.lock2();
    }

    @GetMapping("/lock3")
    public Object lock3() {
        return redisLockService.lock3();
    }

    @GetMapping("/lock4")
    public Object lock4() {
        return redisLockService.lock4();
    }

    @GetMapping("/lock5")
    public Object lock5() {
        return redisLockService.lock5();
    }
}
