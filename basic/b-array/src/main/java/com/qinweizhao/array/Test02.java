package com.qinweizhao.array;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class Test02 {

    public static void main(String[] args) {
        Man m = new Man(10, "高小一");

        //静态初始化需要在声明后直接初始化
        Man[] mans = {
                m,
                new Man(20, "高小二"),
                new Man(30, "高小三"),
                new Man(40, "高小四"),
                new Man(50, "高小五")
        };

        mans[0] = m;


        for (int i = 0; i < mans.length; i++) {
            Man man = mans[i];
            System.out.println(man);
        }
        //增强for循环(读取元素的值)
        for (Man man : mans) {
            System.out.println(man);
        }


    }

}

class Man {
    private int id;
    private String name;

    public Man() {
    }

    public Man(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id:" + id + ",name:" + this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
