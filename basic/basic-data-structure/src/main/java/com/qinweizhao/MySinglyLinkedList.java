package com.qinweizhao;

/**
 * 基于单向链表实现元素存取的容器
 *
 * @param <E>
 */
public class MySinglyLinkedList<E> implements MyList<E> {

    private Node head;//存放链表中的头节点。
    private int size;//记录元素个数。

    public static void main(String[] args) {
        MySinglyLinkedList<String> mySinglyLinkedList = new MySinglyLinkedList<>();
        mySinglyLinkedList.add("a");
        mySinglyLinkedList.add("b");
        mySinglyLinkedList.add("c");
        mySinglyLinkedList.add("d");
        System.out.println(mySinglyLinkedList.size());
        System.out.println(mySinglyLinkedList.remove(0));
        for (int i = 0; i < mySinglyLinkedList.size(); i++) {
            System.out.println(mySinglyLinkedList.get(i));
        }
    }

    /**
     * 向链表中添加元素
     *
     * @param element
     */
    @Override
    public void add(E element) {
        //创建节点
        Node<E> node = new Node<>(element, null);
        //找到尾节点
        Node tail = getTail();
        //节点的挂接
        if (tail == null)
            this.head = node;
        else
            tail.next = node;
        //记录元素个数
        this.size++;
    }

    /**
     * 找尾节点
     */
    private Node getTail() {
        //头节点是否存在
        if (this.head == null) {
            return null;
        }
        //查找尾节点
        Node node = this.head;
        while (true) {
            if (node.next == null) break;
            node = node.next;//移动指针，指向下一个节点
        }
        return node;
    }

    /**
     * 根据元素的位置获取元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        //校验Index的合法性
        this.checkIndex(index);
        //根据位置获取指定节点
        Node<E> node = this.getNode(index);
        //将该节点中的元素返回
        return node.item;
    }

    /**
     * 对Index进行校验
     */
    private void checkIndex(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + this.size);
        }
    }

    /**
     * 根据位置获取节点
     */
    private Node getNode(int index) {
        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 根据元素的位置删除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //校验Index的合法性
        this.checkIndex(index);
        //根据位置找到该节点对象
        Node<E> node = this.getNode(index);
        //获取该节点对象中的元素
        E item = node.item;
        //将该节点对象从单向链表中移除
        //判断当前删除的节点是否为头结点
        if (this.head == node) {
            this.head = node.next;
        } else {
            Node<E> temp = this.head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = node.next;
        }
        node.next = null;
        //记录元素个数
        this.size--;
        //将该元素返回
        return item;
    }

    /**
     * 定义单向链表中的节点对象
     */
    class Node<E> {
        private E item;//存储元素
        private Node next;//存储下一个节点对象的地址

        Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
