package com.qinweizhao.generics;

/**
 * 泛型类
 * @author qinweizhao
 * @since 2021-12-29
 */
public class BoxGeneric<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        BoxGeneric<Integer> integerBoxGeneric = new BoxGeneric<Integer>();
        BoxGeneric<String> stringBoxGeneric = new BoxGeneric<String>();

        integerBoxGeneric.add(10);
        stringBoxGeneric.add("Java 泛型");

        System.out.printf("整型值为 :%d\n\n", integerBoxGeneric.get());
        System.out.printf("字符串为 :%s\n", stringBoxGeneric.get());
    }
}