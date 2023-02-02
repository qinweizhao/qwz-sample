package com.qinweizhao.basic.container.util;

import com.qinweizhao.basic.container.common.Student;

import java.util.Comparator;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class StudentComparatorMain implements Comparator<Student> {

    //定义比较规则
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        }
        if (o1.getAge() == o2.getAge()) {
            return o1.getName().compareTo(o2.getName());
        }
        return -1;
    }
}
