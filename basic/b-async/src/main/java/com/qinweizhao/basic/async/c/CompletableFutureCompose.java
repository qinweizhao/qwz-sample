package com.qinweizhao.basic.async.c;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

/**
 * @author qinweizhao
 * @since 2023-02-15
 */
public class CompletableFutureCompose {

    /**
     * thenAccept子任务和父任务公用同一个线程
     */
    @SneakyThrows
    public static void thenRunAsync() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });
        CompletableFuture<Void> cf2 = cf1.thenRunAsync(() -> System.out.println(Thread.currentThread() + " cf2 do something..."));
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    public static void main(String[] args) {
        thenRunAsync();
    }
}

