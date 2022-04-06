package com.io;

import java.io.RandomAccessFile;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("d:/sxt7.txt", "rw");
            //将若干数据写入到文件中
            int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
            for (int i = 0; i < arr.length; i++) {
                raf.writeInt(arr[i]);
            }
            raf.seek(4);
            System.out.println(raf.readInt());

            //隔一个读一个数据
            for (int i = 0; i < 10; i += 2) {
                raf.seek(i * 4);
                System.out.print(raf.readInt() + "\t");
            }
            System.out.println();
            //在第8个字节位置插入一个新的数据45，替换之前的数据30
            raf.seek(8);
            raf.writeInt(45);
            for (int i = 0; i < 10; i += 2) {
                raf.seek(i * 4);
                System.out.print(raf.readInt() + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
