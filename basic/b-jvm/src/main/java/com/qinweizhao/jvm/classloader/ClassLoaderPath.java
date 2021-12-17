package com.qinweizhao.jvm.classloader;

import sun.security.util.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * 类加载器的加载路径
 * @author qinweizhao
 * @since 2021/12/17
 */
public class ClassLoaderPath {

    public static void main(String[] args) {
        System.out.println("**********启动类加载器**************");

        //获取 BootstrapClassLoader 能够加载的 api 的路径
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }

        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("***********扩展类加载器*************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        //从上面的路径中随意选择一个类,来看看他的类加载器是什么:扩展类加载器
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        //sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println(classLoader1);

    }
}
