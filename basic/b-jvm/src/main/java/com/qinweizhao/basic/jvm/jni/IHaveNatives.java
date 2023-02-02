package com.qinweizhao.basic.jvm.jni;

/**
 * 本地方法
 * 标识符 native 可以与其他所有的 Java 标识符连用，但是 abstract 除外。
 *
 * @author qinweizhao
 * @since 2022-04-01
 */
public class IHaveNatives {

    //abstract 没有方法体
    // public abstract void abstractMethod(int x);

    /**
     * 使用native标识为本地方法接口
     */
    native static public long Native2();

    //native 和 abstract不能共存，native是有方法体的，由C语言来实现
    public native void Native1(int x);

    native synchronized private float Native3(Object o);

    native void Native4(int[] array) throws Exception;

}
