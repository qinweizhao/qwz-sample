package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qinweizhao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 薪资
     */
    private int salary;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地区
     */
    private String area;

}
