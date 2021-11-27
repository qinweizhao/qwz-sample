package com.qinweizhao;

import java.util.Arrays;

/**
 * 二维数组的练习。
 * 使用Object[][]存储整个表格的数据。
 */
public class Test04 {
    public static void main(String[] args) {
        //每一个一维数组代表一行数据
        Object[] emp0 = {1001, "高小一", 18, "程序员", "2019-9-9"};
        Object[] emp1 = {1002, "高小二", 19, "程序员", "2019-10-9"};
        Object[] emp2 = {1003, "高小三", 20, "程序员", "2019-12-9"};

        Object[][] emps = new Object[3][];
        emps[0] = emp0;
        emps[1] = emp1;
        emps[2] = emp2;

        //打印二维数组的内容（表格数据打印）
        for (int i = 0; i < emps.length; i++) {
            System.out.println(Arrays.toString(emps[i]));
        }

        //使用嵌套循环打印二维数组（打印表格数据）
        for (int i = 0; i < emps.length; i++) {

            for (int j = 0; j < emps[i].length; j++) {
                System.out.print(emps[i][j] + "\t");
            }

            System.out.println();
        }


    }
}
