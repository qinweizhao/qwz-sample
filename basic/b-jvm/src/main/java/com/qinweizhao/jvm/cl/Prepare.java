package com.qinweizhao.jvm.cl;

/**
 * 加载阶段-准备
 *
 * @author qinweizhao
 * @since 2021-12-14
 */
public class Prepare {

    /**
     * 准备阶段 a = 0 ,初始化阶段赋值为 1
     *
     *
     * 不包含 final 修饰的 static 因为被 final 修饰的会在编译期就分配，在准备阶段显式初始化。
     *
     * 这里不会为实例变量分配初始化，类变量会分配在方法区中，而实例变量是会随着对象一起分配到 Java 堆中。
     */
    private static int a = 1;

    public static void main(String[] args) {
        System.out.println(a);
    }
}
