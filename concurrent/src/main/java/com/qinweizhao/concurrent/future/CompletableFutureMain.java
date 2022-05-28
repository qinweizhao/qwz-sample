package com.qinweizhao.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qinweizhao
 * @since 2022/5/28
 */
public class CompletableFutureMain {

    /**
     * 创建一个线程池
     */
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 无返回值
        createSyncNoReturn();
        // 又返回值
        Long syncHasReturn = createSyncHasReturn();
        System.out.println(syncHasReturn);

        /**
         * 线程串行化
         * 1）、thenRun：不能获取到上一步的执行结果，无返回值
         *  .thenRunAsync(() -> {
         *             System.out.println("任务2启动了...");
         *         }, executor);
         * 2）、thenAcceptAsync;能接受上一步结果，但是无返回值
         * 3）、thenApplyAsync：;能接受上一步结果，有返回值
         */
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 4;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).thenApplyAsync(res -> {
//            System.out.println("任务2启动了..." + res);
//
//            return "Hello " + res;
//        }, executor);




        /**
         * 两个都完成
         */
//        CompletableFuture<Object> future01 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务1线程：" + Thread.currentThread().getId());
//            int i = 10 / 4;
//            System.out.println("任务1结束：" );
//            return i;
//        }, executor);
//
//        CompletableFuture<Object> future02 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务2线程：" + Thread.currentThread().getId());
//
//            try {
//                Thread.sleep(3000);
//                System.out.println("任务2结束：" );
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Hello";
//        }, executor);

//        future01.runAfterBothAsync(future02,()->{
//            System.out.println("任务3开始...");
//        },executor);
        // void accept(T t, U u);
//        future01.thenAcceptBothAsync(future02,(f1,f2)->{
//            System.out.println("任务3开始...之前的结果："+f1+"--》"+f2);
//        },executor);
        //R apply(T t, U u);
//        CompletableFuture<String> future = future01.thenCombineAsync(future02, (f1, f2) -> {
//            return f1 + "：" + f2 + " -> Haha";
//        }, executor);

        /**
         * 两个任务，只要有一个完成，我们就执行任务3
         * runAfterEitherAsync：不感知结果，自己没有返回值
         * acceptEitherAsync：感知结果，自己没有返回值
         * applyToEitherAsync：感知结果，自己有返回值
         */
//        future01.runAfterEitherAsync(future02,()->{
//            System.out.println("任务3开始...之前的结果：");
//        },executor);
        //void accept(T t);
//        future01.acceptEitherAsync(future02,(res)->{
//            System.out.println("任务3开始...之前的结果："+res);
//        },executor);
//        CompletableFuture<String> future = future01.applyToEitherAsync(future02, res -> {
//            System.out.println("任务3开始...之前的结果：" + res);
//            return res.toString() + "->哈哈";
//        }, executor);

        CompletableFuture<String> futureImg = CompletableFuture.supplyAsync(() -> {
            System.out.println("查询商品的图片信息");
            return "hello.jpg";
        },executor);

        CompletableFuture<String> futureAttr = CompletableFuture.supplyAsync(() -> {
            System.out.println("查询商品的属性");
            return "黑色+256G";
        },executor);

        CompletableFuture<String> futureDesc = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("查询商品介绍");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "华为";
        },executor);

//        CompletableFuture<Void> allOf = CompletableFuture.allOf(futureImg, futureAttr, futureDesc);
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(futureImg, futureAttr, futureDesc);
        anyOf.get();//等待所有结果完成

//        System.out.println("main....end...."+futureImg.get()+"=>"+futureAttr.get()+"=>"+futureDesc.get());
        System.out.println("main....end...."+anyOf.get());




    }

    public static void createSyncNoReturn(){
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
        }, executor);
    }
    public static Long createSyncHasReturn() throws ExecutionException, InterruptedException {
        CompletableFuture<Long> longCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            return Thread.currentThread().getId();
        }, executor);
        // get 阻塞
        return longCompletableFuture.get();
    }

    public static void whenComplete(){
        CompletableFuture<Long> longCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            return Thread.currentThread().getId();
        }, executor).whenComplete((response, exception) -> {
            System.out.println("运行结果：" + response);
            System.out.println("异常：" + exception);
        }).exceptionally(exception-> 10L);
    }

}
