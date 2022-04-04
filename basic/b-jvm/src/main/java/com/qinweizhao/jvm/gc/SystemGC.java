package com.qinweizhao.jvm.gc;

/**
 * @author qinweizhao
 * @since 2022/4/4
 */
public class SystemGC {
    public static void main(String[] args) {
        new SystemGC();
        //提醒jvm的垃圾回收器执行gc,但是不确定是否马上执行gc
        System.gc();
        //强制调用失去引用的对象的finalize()方法
        System.runFinalization();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 重写了finalize()");
    }
}
