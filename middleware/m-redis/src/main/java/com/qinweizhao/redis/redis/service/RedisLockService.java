package com.qinweizhao.redis.redis.service;

/**
 * @author qinweizhao
 * @since 2022/5/17
 */
public interface RedisLockService {

    /**
     * 阶段一
     *
     * @return Object
     */
    Object lock1();

    /**
     * 阶段二
     *
     * @return Object
     */
    Object lock2();

    /**
     * 阶段三
     *
     * @return Object
     */
    Object lock3();

    /**
     * 阶段四
     *
     * @return Object
     */
    Object lock4();

    /**
     * 阶段五
     *
     * @return Object
     */
    Object lock5();


}
