package com.qinweizhao.jvm.cl;

/**
 * 初始化
 * 初始化就是执行类构造器方法 <clinit>() 方法的过程
 * 此方法不需要定义，是 javac 编译器自动收集类中的所有类变量的赋值动作和静态代码块中的语句合并而来。
 * 指令按语句在源文件中出现的顺序执行
 *
 * @author qinweizhao
 * @since 2021/12/17
 */
public class ClassInit {

    private static int num = 1;

    static {
        num=2;
        number = 20;
        System.out.println(num);
        //报错：Illegal forward reference (非法的前向引用)。
        // System.out.println(number);
    }


    private static int number = 10;

    public static void main(String[] args) {
        // 2
        System.out.println(ClassInit.num);
        // 10
        System.out.println(ClassInit.number);
    }
}
