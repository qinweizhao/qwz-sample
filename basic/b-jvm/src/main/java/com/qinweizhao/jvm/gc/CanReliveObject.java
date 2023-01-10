package com.qinweizhao.jvm.gc;

/**
 * @author qinweizhao
 * @since 2022-04-04
 */
public class CanReliveObject {

    /**
     * 类变量，属于 GC Root
     */
    public static CanReliveObject obj;

    public static void main(String[] args) {
        try {
            obj = new CanReliveObject();
            // 对象第一次成功拯救自己
            obj = null;
            System.gc();//调用垃圾回收器
            System.out.println("第1次 gc");
            // 因为Finalizer线程优先级很低，暂停2秒，以等待它
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is still alive");
            }
            System.out.println("第2次 gc");
            // 下面这段代码与上面的完全相同，但是这次自救却失败了
            obj = null;
            System.gc();
            // 因为Finalizer线程优先级很低，暂停2秒，以等待它
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is still alive");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 此方法只能被调用一次
     *
     * @throws Throwable t
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类重写的finalize()方法");
        //当前待回收的对象在finalize()方法中与引用链上的一个对象obj建立了联系
        obj = this;
    }
}
