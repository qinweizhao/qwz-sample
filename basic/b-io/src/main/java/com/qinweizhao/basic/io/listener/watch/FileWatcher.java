package com.qinweizhao.basic.io.listener.watch;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FileWatcher {
    public static void main(String[] args) throws Exception {
        System.out.println("启动");
        // 创建WatchService实例
        WatchService watchService = FileSystems.getDefault().newWatchService();
        // 注册要监视的目录
        Path path = Paths.get("C:\\Users\\YVKG\\Desktop\\VPF");
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        // 无限循环监听事件
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);
        ScheduledFuture<?> schedule = threadPool.scheduleAtFixedRate(
                () -> {
                    try {
                        WatchKey key = watchService.take();

                        for (WatchEvent<?> event : key.pollEvents()) {
                            System.out.println("文件 " + event.context() + " 发生了 " + event.kind() + " 事件");
                            Path file = path.resolve((Path) event.context());
                            System.out.println();
                            if (event.kind().name().equals(StandardWatchEventKinds.ENTRY_CREATE.name())) {
                                handler(file.toFile());
                            }
                        }

                        key.reset(); // 处理完事件后取消该Key
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }, 1, 1, TimeUnit.SECONDS);
    }

    private static void handler(File file) {

        String dFileName ="C:\\Users\\YVKG\\Desktop\\VPFO\\"+ UUID.randomUUID()+".pdf";
        File dFile = new File(dFileName);
        System.out.println("开始拷贝");
        boolean flag = true;
        while (flag){

            try {
                long srcLength = file.length();
                Thread.sleep(5);
                long desLength = file.length();
                if (desLength!=srcLength){
                    System.out.println("拷贝中");
                    continue;
                }
                FileUtils.copyFile(file,dFile);
                flag=false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("完成拷贝");


        System.out.println("开始删除");
        try {
            FileUtils.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("完成删除");

    }
}
