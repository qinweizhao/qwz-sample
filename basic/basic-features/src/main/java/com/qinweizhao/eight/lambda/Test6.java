package com.qinweizhao.eight.lambda;

import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");
        list.add("b");
        list.add("c");
        list.sort((o1, o2) -> o1.compareTo(o2));
        list.forEach(System.out::println);
    }
}
