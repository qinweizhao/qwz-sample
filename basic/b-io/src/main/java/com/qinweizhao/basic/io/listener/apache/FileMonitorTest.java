package com.qinweizhao.basic.io.listener.apache;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.util.concurrent.TimeUnit;

/**
 * @author qinweizhao
 * @since 2023-06-21
 */
public class FileMonitorTest {

    public static void main(String[] args) throws Exception {
        //Monitor Directory
//        String rootDir = "/Users/weizhao/Data/Tem";
        String rootDir = "/Users/weizhao/Downloads";
        //Interval time 5 seconds(间隔时间5秒)
        long intervalTime = TimeUnit.SECONDS.toMillis(2);

        FileAlterationObserver observer = new FileAlterationObserver(rootDir);

        //Set file change listener
        observer.addListener(new FileListener());
        //Create file change monitor
        FileAlterationMonitor monitor = new FileAlterationMonitor(intervalTime, observer);
        //start monitor
        monitor.start();

        //设置关闭时间
//        Thread.sleep(3000);
//        monitor.stop();

    }
}