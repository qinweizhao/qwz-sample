package com.qinweizhao.jvm.cl;


/**
 * jvm 支持两种类型的类加载器。分别为引导类加载器和自定义类加载器
 *
 * @author qinweizhao
 * @since 2021-12-17
 */
public class GetClassLoader {

    public static void main(String[] args) {

        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // jdk 1.8 sun.misc.Launcher$AppClassLoader@18b4aac2
        // jdk 11 jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
        System.out.println(systemClassLoader);

        // 获取上的类加载器
        // 扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        // jdk 1.8 sun.misc.Launcher$ExtClassLoader@74a14482
        // jdk 11 jdk.internal.loader.ClassLoaders$PlatformClassLoader@96532d6
        System.out.println(extClassLoader);

        // 获取上的类加载器
        // 引导类加载器(无法获取)
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        // null
        System.out.println(bootstrapClassLoader);


        // 获取用户自定义的类加载器
        // 默认使用系统类加载器
        ClassLoader classLoader = GetClassLoader.class.getClassLoader();
        // jdk 1.8 sun.misc.Launcher$AppClassLoader@18b4aac2
        // jdk 11 jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
        System.out.println(classLoader);

        // String 类使用的加载器
        ClassLoader stringClassLoader = String.class.getClassLoader();
        // null (Java的核心类库都是使用引导类加载器进行加载的)
        System.out.println(stringClassLoader);
    }
}
