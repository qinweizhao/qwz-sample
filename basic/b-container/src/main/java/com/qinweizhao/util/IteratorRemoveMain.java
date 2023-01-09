package com.qinweizhao.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器移除元素
 * @author qinweizhao
 * @since 2021-11-26
 */
public class IteratorRemoveMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            //不要在一次循环中多次调用next方法。
            String value = iterator.next();
            if ("c".equals(value)) {
                iterator.remove();
            }
        }
        System.out.println("----------------");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
            list.add("dddd");
        }
    }
}
