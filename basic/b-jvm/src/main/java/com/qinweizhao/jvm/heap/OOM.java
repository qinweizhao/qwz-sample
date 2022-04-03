package com.qinweizhao.jvm.heap;

import java.util.ArrayList;
import java.util.Random;

/**
 * -Xms600m -Xmx600m
 * @author qinweizhao
 * @since 2022/4/3
 */
public class OOM {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<>();
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024 * 1024)));
        }
    }
}

class Picture {
    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}
