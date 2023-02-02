package com.qinweizhao.basic.jvm.gc;

/**
 * 代码测试Java中没有使用引用计数算法来判断对象是否为垃圾
 * VM参数：-XX:+PrintGCDetails
 *
 * @author qinweizhao
 * @since 2022-04-04
 */
public class RefCountGC {

    /**
     * 故意占用空间10M
     */
    byte data[] = new byte[1024 * 1024 * 10];

    private Object ref = null;

    public static void main(String[] args) {
        RefCountGC refCountGC1 = new RefCountGC();
        RefCountGC refCountGC2 = new RefCountGC();

        //循环引用
        refCountGC1.ref = refCountGC2;
        refCountGC2.ref = refCountGC1;

        //取消外界对其的引用
        refCountGC1 = null;
        refCountGC2 = null;

        //手动GC
        ///把这行代码注释掉
        System.gc();
    }

}
