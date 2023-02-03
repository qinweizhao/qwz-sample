package com.qinweizhao.basic.generics;

/**
 * Class<T> 和 Class<?> 区别
 *
 * @author qinweizhao
 * @since 2021-12-29
 */
public class Test {

    public static <T> T createInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static void main(String[] args) throws
            InstantiationException, IllegalAccessException {
        A a = createInstance(A.class);
        B b = createInstance(B.class);
    }

}

class A {
}

class B {
}