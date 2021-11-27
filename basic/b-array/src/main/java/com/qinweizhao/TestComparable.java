package com.qinweizhao;

import java.util.Arrays;

public class TestComparable {
    public static void main(String[] args) {
        Man2[] msMans = {
                new Man2(3, "a"),
                new Man2(60, "b"),
                new Man2(2, "c")
        };

        Arrays.sort(msMans);
        System.out.println(Arrays.toString(msMans));
    }
}

class Man2 implements Comparable {
    int age;
    int id;
    String name;

    public Man2(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public int compareTo(Object o) {
        Man2 man22 = (Man2) o;
        if (this.age < man22.age) {
            return -1;
        }
        if (this.age > man22.age) {
            return 1;
        }
        return 0;
    }
}
