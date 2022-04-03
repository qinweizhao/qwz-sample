package com.qinweizhao.jvm.heap;

/**
 * 测试：大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *
 * @author qinweizhao
 * @since 2022/4/3
 */
public class YoungOldArea {

    /**
     * 新生代 20m ，Eden 16m， s0 2m， s1 2m 老年代 40m
     *
     * @param args args
     */
    public static void main(String[] args) {
        //Eden 区无法存放buffer  晋升老年代
        //20m
        byte[] buffer = new byte[1024 * 1024 * 20];
    }

}
