package com.qinweizhao;

/**
 * 基于链表结构存取元素的方法API定义
 *
 * @author qinweizhao
 * @since 2021-11-26
 */
public interface MyList<E> {
    void add(E element);

    E get(int index);

    int size();

    E remove(int index);
}
