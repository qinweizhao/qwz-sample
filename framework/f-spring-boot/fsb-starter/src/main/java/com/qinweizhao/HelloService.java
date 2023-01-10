package com.qinweizhao;

/**
 * @author qinweizhao
 * @since 2021-11-29
 */
public class HelloService {

    private String name;

    private String age;

    public String info() {
        return  "姓名" +name + " 年龄 " + age + " !";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
