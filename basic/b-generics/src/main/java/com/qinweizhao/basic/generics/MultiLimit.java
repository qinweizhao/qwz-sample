package com.qinweizhao.basic.generics;

/***接口A*/
interface MultiLimitInterfaceA {
}

/*** i口в*/
interface MultiLimitInterfaceB {
}

/**
 * @author qinweizhao
 * @since 2021-12-29
 */
public class MultiLimit implements MultiLimitInterfaceA, MultiLimitInterfaceB {

    /**
     * 符号设定多重边界
     *
     * @param t   t
     * @param <T> T
     */
    public static <T extends MultiLimitInterfaceA & MultiLimitInterfaceB> void test(T t) {

    }

}