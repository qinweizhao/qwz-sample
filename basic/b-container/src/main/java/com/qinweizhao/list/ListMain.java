package com.qinweizhao.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class ListMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            //产生随机数
            int num = (int) (Math.random() * 10 + 1);
            //判断当前元素在容器中是否存在
            if (!list.contains(num)) {
                list.add(num);
            }
            //结束循环
            if (list.size() == 10) {
                break;
            }
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }


//    public static void main(String[] args) {
//        testList();
//    }


    public static void testList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(7);

        LinkedList<Integer> list2 = new LinkedList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(18);
        list.add(17);
        for (Integer i : list) {
            System.out.println(i);
        }

        for (Integer i : list2) {
            System.out.println(i);
        }
    }
}
