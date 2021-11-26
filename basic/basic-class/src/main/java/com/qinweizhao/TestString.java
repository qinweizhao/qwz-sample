package com.qinweizhao;

public class TestString {
    public static void main(String[] args) {
        String str = "aabb";        //不可变字符序列
        StringBuilder sb = null;    //可变字符序列，线程不安全，效率高
        StringBuffer sb2 = null;   //可变字符序列，线程安全，效率低

        sb = new StringBuilder("gao");

        sb.append(123);
        sb.append(456);
        System.out.println(sb);
        sb.append("aa").append("bb").append("cc");

        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        System.out.println(sb);

        /**StringBuffer，下面的方法同样适用StringBuilder*/
        sb2 = new StringBuffer("北京尚学堂");
        sb2.insert(0, "爱").insert(0, "我");//插入字符串
        System.out.println(sb2);
        sb2.delete(0, 2);//删除子字符串
        System.out.println(sb2);
        sb2.deleteCharAt(0).deleteCharAt(0);//删除某个字符
        System.out.println(sb2.charAt(0));//获取某个字符
        System.out.println(sb2.reverse());//字符串逆序


    }
}
