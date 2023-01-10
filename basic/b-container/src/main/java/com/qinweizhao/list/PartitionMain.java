package com.qinweizhao.list;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class PartitionMain {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        int size = 89;
        for (int i = 0; i < size; i++) {
            list.add("hello-" + i);
        }
        // 切割大集合到指定的长度：11
        List<List<String>> rsList = Lists.partition(list, 10);
        int i = 0;
        for (List<String> obj : rsList) {
            System.out.println("obj" + obj);
        }
    }
}
