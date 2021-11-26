package com.qinweizhao.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class SetMain {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int num = (int) (Math.random() * 10 + 1);
            //将元素添加容器中，由于Set类型容器是不允许有重复元素的，所以不需要判断。
            set.add(num);
            //结束循环
            if (set.size() == 10) {
                break;
            }
        }
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
