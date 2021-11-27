package com.qinweizhao;

import java.lang.reflect.Constructor;

public class GetConstructor2 {
    public static void main(String[] args) throws Exception {
        Class clazz = Users.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("OldLu", 18);
        Users users = (Users) o;
        System.out.println(users.getUsername() + "\t" + users.getUserage());
    }
}
