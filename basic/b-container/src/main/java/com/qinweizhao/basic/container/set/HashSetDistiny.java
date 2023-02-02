package com.qinweizhao.basic.container.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinweizhao
 * @since 2022-05-11
 */
public class HashSetDistiny {

    public static void main(String[] args) {
        Set<Test> set = new HashSet<>();
        Test qwz = new Test("qwz", 11);
        Test qwz2 = new Test("qwz", 11);
        set.add(qwz);
        System.out.println(qwz.hashCode());
        set.add(qwz2);
        System.out.println(qwz2.hashCode());
        System.out.println(set.toString());
    }
}
