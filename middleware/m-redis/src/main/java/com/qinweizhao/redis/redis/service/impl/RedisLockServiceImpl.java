package com.qinweizhao.redis.redis.service.impl;

import com.qinweizhao.redis.redis.service.RedisLockService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author qinweizhao
 * @since 2022-05-17
 */
@Service
public class RedisLockServiceImpl implements RedisLockService {


    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public Object lock1() {
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "111");
        if (Boolean.TRUE.equals(lock)) {
            // 加锁成功..执行业务
            Object dataFromDb = this.getDataFromDb();
            //删除锁
            redisTemplate.delete("1ock");
            return dataFromDb;
        } else {
            //自旋的方式
            return lock1();
        }
    }

    @Override
    public Object lock2() {
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "111");
        if (Boolean.TRUE.equals(lock)) {
            // 设置过期时间
            redisTemplate.expire("lock", 30, TimeUnit.SECONDS);
            // 加锁成功..执行业务
            Object dataFromDb = this.getDataFromDb();
            //删除锁
            redisTemplate.delete("1ock");
            return dataFromDb;
        } else {
            //自旋的方式
            return lock2();
        }
    }


    @Override
    public Object lock3() {
        // 加锁和设置过期时间一条命令执行 即原子操作
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "111", 30, TimeUnit.SECONDS);
        if (Boolean.TRUE.equals(lock)) {
            // 加锁成功..执行业务
            Object dataFromDb = this.getDataFromDb();
            //删除锁
            redisTemplate.delete("1ock");
            return dataFromDb;
        } else {
            //自旋的方式
            return lock3();
        }
    }


    @Override
    public Object lock4() {
        String token = UUID.randomUUID().toString();
        // 加锁和设置过期时间一条命令执行 即原子操作
        // 占坑时使用 token
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", token, 30, TimeUnit.SECONDS);
        if (Boolean.TRUE.equals(lock)) {
            // 加锁成功..执行业务
            Object dataFromDb = this.getDataFromDb();


            //获取值对比+对比成功删除=原子操作  lua脚本解锁
            Object lockValue = redisTemplate.opsForValue().get("lock");
            if (token.equals(String.valueOf(lockValue))) {
                //删除自己的锁
                redisTemplate.delete("lock");
            }

            return dataFromDb;
        } else {
            //自旋的方式
            return lock2();
        }
    }

    @Override
    public Object lock5() {
        String token = UUID.randomUUID().toString();
        // 加锁+设置过期时间=原子操作
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", token, 30, TimeUnit.SECONDS);
        if (Boolean.TRUE.equals(lock)) {
            Object dataFromDb;
            try {
                // 加锁成功..执行业务
                dataFromDb = this.getDataFromDb();
            } catch (Exception e) {
                throw new RuntimeException("异常");
            } finally {
                // 获取值对比+对比成功删除=原子操作  lua脚本解锁
                String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
                //删除锁
                redisTemplate.execute(new DefaultRedisScript<>(script, Long.class)
                        , Collections.singletonList("lock"), token);
            }
            return dataFromDb;
        } else {
            //自旋的方式
            return lock5();
        }
    }


    /**
     * 模拟从数据库中获取数据
     *
     * @return mock data
     */
    private Object getDataFromDb() {
        // mock data
        return "mock data";
    }

}
