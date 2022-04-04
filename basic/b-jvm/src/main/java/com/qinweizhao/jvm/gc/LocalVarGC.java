package com.qinweizhao.jvm.gc;

/**
 * -XX:+PrintGCDetails
 * -Xms256m -Xmx256m -XX:+PrintGCDetails -XX:PretenureSizeThreshold=15m
 * @author qinweizhao
 * @since 2022/4/4
 */
public class LocalVarGC {
    public void localvarGC1() {
        //10MB
        byte[] buffer = new byte[10 * 1024 * 1024];
        System.gc();
    }

    public void localvarGC2() {
        byte[] buffer = new byte[10 * 1024 * 1024];
        buffer = null;
        System.gc();
    }

    public void localvarGC3() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        System.gc();
    }

    public void localvarGC4() {
        {
            byte[] buffer = new byte[10 * 1024 * 1024];
        }
        int value = 10;
        System.gc();
    }

    public void localvarGC5() {
        localvarGC1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGC local = new LocalVarGC();
        //通过在main方法调用这几个方法进行测试
        local.localvarGC1();
    }
}

