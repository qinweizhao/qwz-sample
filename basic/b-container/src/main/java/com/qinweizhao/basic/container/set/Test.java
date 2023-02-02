package com.qinweizhao.basic.container.set;

import java.util.Objects;

/**
 * @author qinweizhao
 * @since 2022-05-11
 */
public class Test {

    private String name;
    private Integer age;

    public Test(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name) && Objects.equals(age, test.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
