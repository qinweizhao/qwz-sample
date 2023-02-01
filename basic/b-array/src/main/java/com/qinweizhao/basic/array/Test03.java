package com.qinweizhao.basic.array;

import java.util.Arrays;

/**
 * 测试java.util.Arrays类。
 * 这个类时java提供给我们操作数组的工具类。
 * 提供了常见的：排序、查找、填充、打印数组内容的相关的方法。
 *
 * @author qinweizhao
 * @since 2021-11-26
 */
public class Test03 {
    public static void main(String[] args) {
//        int[]  a = {100,200,300};
//        //测试打印
//        System.out.println(Arrays.toString(a));

        //测试排序
//        int[ ] a = {1,2,323,23,543,12,59};
//        System.out.println(Arrays.toString(a));
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));

        //测试二分法查找
//        int[ ] a = {1,2,323,23,543,12,59};
//        System.out.println(Arrays.toString(a));
//        Arrays.sort(a);   //使用二分法查找，必须先对数组进行排序;
//        System.out.println(Arrays.toString(a));
//        //返回排序后新的索引位置,若未找到返回负数。
//        System.out.println("该元素的索引："+Arrays.binarySearch(a, 12));

        //填充
        int[] a = {1, 2, 323, 23, 543, 12, 59};
        System.out.println(Arrays.toString(a));
        Arrays.fill(a, 2, 4, 100);  //将2到4索引的元素替换为100;
        System.out.println(Arrays.toString(a));


    }
}
