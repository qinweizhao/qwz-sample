package com.qinweizhao.basic.reflect;

import java.lang.reflect.Constructor;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class GetConstructor2 {
    public static void main(String[] args) throws Exception {
        Class clazz = Users.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("OldLu", 18);
        Users users = (Users) o;
        System.out.println(users.getUsername() + "\t" + users.getUserage());
    }
}
