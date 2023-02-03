package com.qinweizhao.basic.reflect;

import java.lang.reflect.Field;

public class GetField2 {
    public static void main(String[] args) throws Exception {
        Class clazz = Users.class;
        Field field = clazz.getField("userage");
        //对象实例化
        Object obj = clazz.newInstance();
        //为成员变量赋予新的值
        field.set(obj, 18);
        //获取成员变量的值
        Object o = field.get(obj);
        System.out.println(o);

    }
}
