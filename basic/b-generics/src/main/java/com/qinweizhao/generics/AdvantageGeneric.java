package com.qinweizhao.generics;

/**
 * 泛型带来的好处
 * @author qinweizhao
 * @since 2021-12-29
 */
public class AdvantageGeneric<T> {
    private T t;
    public void set(T t) { this.t = t; }
    public T get() { return t; }

    public static void main(String[] args) {
        // do nothing
    }

    /**
     * 不指定类型
     */
    public void noSpecifyType(){
        AdvantageGeneric advantageGeneric = new AdvantageGeneric();
        advantageGeneric.set("test");
        // 需要强制类型转换
        String test = (String) advantageGeneric.get();
        System.out.println(test);
    }

    /**
     * 指定类型
     */
    public void specifyType(){
        AdvantageGeneric<String> advantageGeneric = new AdvantageGeneric<>();
        advantageGeneric.set("test");
        // 不需要强制类型转换
        String test = advantageGeneric.get();
        System.out.println(test);
    }
}

