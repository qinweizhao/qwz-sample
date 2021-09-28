package com.qinweizhao;

/**
 * @author YVKG
 */
public class User {

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地区
     */
    private String area;

    public User(Integer age, String username, String sex, String area) {
        this.age=age;
        this.username = username;
        this.area = area;
        this.sex = sex;
    }

    public User(String username, String sex, String area) {
        this.username = username;
        this.area = area;
        this.sex = sex;
    }

    public User(String sex, String area) {
        this.area = area;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
