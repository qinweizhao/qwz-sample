package com.qinweizhao.redis.redis.controller;

import com.qinweizhao.redis.redis.service.RedisLockService;
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


    public Object lock1(){
       return redisLockService.lock1();
    }
    public Object lock2(){
       return redisLockService.lock2();
    }
}
