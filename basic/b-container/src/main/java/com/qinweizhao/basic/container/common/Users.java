package com.qinweizhao.basic.container.common;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class Users implements Comparable<Users> {
    private String name;
    private int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Users() {
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals...");
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Users users = (Users) o;

        if (age != users.age) {
            return false;
        }
        return name != null ? name.equals(users.name) : users.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    /**
     * 定义比较规则
     * 正数：大，负数：小，0：相等
     *
     * @param o Users
     * @return int
     */
    @Override
    public int compareTo(Users o) {
        if (this.age < o.getAge()) {
            return 1;
        }
        if (this.age == o.getAge()) {
            return this.name.compareTo(o.getName());
        }
        return -1;
    }
}
