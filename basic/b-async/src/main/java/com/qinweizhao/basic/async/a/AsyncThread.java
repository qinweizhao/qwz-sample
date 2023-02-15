package com.qinweizhao.basic.async.a;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qinweizhao
 * @since 2023-02-01
 */
@Slf4j
public class AsyncThread extends Thread {

    @Override
    public void run() {
        System.out.println("Current thread name:" + Thread.currentThread().getName() + " Send email success!");
    }

    public static void main(String[] args) {
        AsyncThread asyncThread = new AsyncThread();
        asyncThread.run();
    }


    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void fun() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                log.info("执行业务逻辑...");
            }
        });
    }

}