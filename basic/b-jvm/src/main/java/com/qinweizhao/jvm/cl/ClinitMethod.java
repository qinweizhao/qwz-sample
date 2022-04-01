package com.qinweizhao.jvm.cl;

/**
 * 若有父类 ，jvm 会保证子类的 执行前，父类的 已经执行完毕
 * @author qinweizhao
 * @since 2021/12/17
 */
public class ClinitMethod {
    static class Father {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        // 加载 Father 类，其次加载 Son 类。
        // 2
        System.out.println(Son.B);
    }
}
