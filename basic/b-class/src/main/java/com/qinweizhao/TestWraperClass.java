package com.qinweizhao;

public class TestWraperClass {
    public static void main(String[] args) {
        //基本数据类型转为对象
        Integer i = new Integer(300);
        Integer i2 = Integer.valueOf(20);

        //包装类对象转为基本数据类型
        double d = i2.doubleValue();

        //将字符串数字转成包装类对象
        Integer i3 = Integer.valueOf("2342");
        Integer i4 = Integer.parseInt("334");


        //将包装类对象转成字符串
        String str = i3.toString();

        //一些常用的常量
        System.out.println(Integer.MAX_VALUE);


        //自动装箱
        Integer a = 300;       //编译器帮你改成：Integer  a  =  Integer.valueOf(300);

        //自动拆箱
        int b = a;          //编译器帮你改成：a.intValue();
        Integer c = null;
//        int  c2 = c;        //编译器帮你改成：c.intValue();
        // java.lang.NullPointerException:对象为null，我们调用了他的属性或方法

        //包装类的缓存问题
        Integer d1 = 4000;
        Integer d2 = 4000;

        //当数字在[-128,127]之间的时候，返回缓存数组中的某个元素。
        Integer d3 = 123;
        Integer d4 = 123;      //Integer.valueOf(123)

        System.out.println(d1 == d2);         //两个不同的对象！
        System.out.println(d3 == d4);         //两个不同的对象！
        System.out.println(d1.equals(d2));


    }
}
