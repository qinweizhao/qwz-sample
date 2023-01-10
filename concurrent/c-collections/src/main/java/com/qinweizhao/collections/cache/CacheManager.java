package com.qinweizhao.collections.cache;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author qinweizhao
 * @since 2022-07-14
 */
@Configuration
@EnableScheduling
public class CacheManager {

    /**
     * 预缓存数据集
     */
    private final static ConcurrentHashMap<String, Object> CACHES;

    /**
     * 单个预缓存生效时间
     * 1 * 60 * 60 * 1000L
     */
    public static final long CACHE_HOLD_TIME = 60 * 60 * 1000L;

    /**
     * 缓存时效时间key标识
     */
    public static final String CACHE_HOLD_TIME_KEY = "hold_time";

    static {
        CACHES = new ConcurrentHashMap<>();
    }

    /**
     * 添加缓存信息(默认缓存1小时)
     *
     * @param cacheName cacheName
     * @param objValue  objValue
     */
    public static void putCache(String cacheName, Object objValue) {
        putCache(cacheName, objValue, CACHE_HOLD_TIME);
    }

    /**
     * 存放一个缓存对象，保存时间为holdTime
     *
     * @param cacheName cacheName
     * @param objValue  objValue
     * @param holdTime  holdTime
     */
    public static void putCache(String cacheName, Object objValue, long holdTime) {
        if (checkCacheName(cacheName)) {
            return;
        }
        CACHES.put(cacheName, objValue);
        CACHES.put(cacheName + CACHE_HOLD_TIME_KEY, System.currentTimeMillis() + holdTime);
    }

    /**
     * 获取缓存数据
     *
     * @param cacheName cacheName
     * @return value
     */
    public static Object getCache(String cacheName) {
        if (checkCacheName(cacheName)) {
            return CACHES.get(cacheName);
        }
        return null;
    }

    /**
     * 检查缓存对象是否存在，
     * 若不存在，则返回false
     * 若存在，检查其是否已过有效期，如果已经过了生效期则删除该缓存并返回false
     *
     * @param cacheName cacheName
     * @return boolean
     */
    public static boolean checkCacheName(String cacheName) {

        Long cacheHoldTime = (Long) CACHES.get(cacheName + CACHE_HOLD_TIME_KEY);
        if (cacheHoldTime == null || cacheHoldTime == 0L) {
            return false;
        }
        if (cacheHoldTime < System.currentTimeMillis()) {
            removeCache(cacheName);
            return false;
        }
        return true;
    }


    /**
     * 清除缓存
     */
    public static void clearCache() {
        CACHES.clear();
    }

    /**
     * 根据key删除信息
     *
     * @param cacheName cacheName
     */
    public static void removeCache(String cacheName) {

        CACHES.remove(cacheName);
        CACHES.remove(cacheName + CACHE_HOLD_TIME_KEY);
    }

    /**
     * 定时删除任务
     */
    @Scheduled(cron = "0 */10 * * * ?")
    private void removeJob() {

        if (CACHES.size() <= 0) {
            return;
        }

        for (Map.Entry<String, Object> next : CACHES.entrySet()) {
            String key = next.getKey();
            if (key.endsWith(CACHE_HOLD_TIME_KEY)) {
                Long value = (Long) next.getValue();
                if (value < System.currentTimeMillis()) {
                    CACHES.remove(key);
                    CACHES.remove(StringUtils.removeEnd(key, CACHE_HOLD_TIME_KEY));
                }
            }
        }
    }

}


