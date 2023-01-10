package com.qinweizhao.jvm.heap;

/**
 *
 * -Xms10m -Xmx10m
 * @author qinweizhao
 * @since 2022-04-03
 */
public class HeapMemory {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
