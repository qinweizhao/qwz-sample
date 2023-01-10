package com.qinweizhao.util.problem.copy;

import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author qinweizhao
 * @since 2022-02-21
 */
public class CopyMain {

    private A getA() {
        A first = new A();
        first.setName("demo");
        // first.setIds(Arrays.asList(1, 2, 3));
        return first;
    }


    public void beanUtils() {
        A first = getA();
        first.setNumber("a");

        B second = new B();
        BeanUtils.copyProperties(first, second);
        for (String each : second.getIds()) {
            System.out.println(each);
        }
    }

    public void beanCopier() {
        A first = getA();
        first.setNumber("a");

        B second = new B();
        final BeanCopier beanCopier = BeanCopier.create(A.class, B.class, false);
        beanCopier.copy(first, second, null);

        for (String each : second.getIds()) {
            // 类型转换异常
            System.out.println(each);
        }
    }


    public void mapstruct() {
        A first = getA();
        // first.setNumber("aa");

        B second = Converter.INSTANCE.aToB(first);
        for (String each : second.getIds()) {
            System.out.println(each);
        }
    }
}
