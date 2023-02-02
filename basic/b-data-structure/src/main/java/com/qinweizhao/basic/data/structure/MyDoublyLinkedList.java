package com.qinweizhao.basic.data.structure;

/**
 * 基于双向链表实现元素存取的容器
 *
 * @author qinweizhao
 * @since 2021-11-26
 */
public class MyDoublyLinkedList<E> implements MyList<E> {

    private Node head; //记录头节点
    private Node tail; //记录尾节点
    private int size; //记录元素个数

    public static void main(String[] args) {
        /*MyList<String> myList = new MyDoublyLinkedList<>();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");
        System.out.println(myList.remove(2));
        System.out.println(myList.size());
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }*/
        MyDoublyLinkedList<String> list = new MyDoublyLinkedList<>();
        list.add("a");
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 向双向链表中添加元素的方法
     *
     * @param element
     */
    @Override
    public void add(E element) {
        this.linkLast(element);
    }

    /**
     * 将节点对象添加到双向链表的尾部
     */
    private void linkLast(E element) {
        //获取尾节点
        Node t = this.tail;
        //创建节点对象
        Node<E> node = new Node<>(t, element, null);
        //将新节点定义为尾节点
        this.tail = node;
        if (t == null) {
            this.head = node;
        } else {
            t.next = node;
        }
        this.size++;
    }

    /**
     * 根据指定位置获取元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        //对Index做合法性校验
        this.checkIndex(index);
        //根据位置查找节点对象
        Node<E> node = this.getNode(index);
        return node.item;
    }

    /**
     * 校验Index的合法性
     */
    private void checkIndex(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
    }

    /**
     * 根据位置获取指定节点对象
     */
    private Node getNode(int index) {
        //判断当前位置距离头或者尾哪个节点更近
        if (index < (this.size >> 1)) {
            Node node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node node = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    /**
     * 返回元素的个数
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 根据指定位置删除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //对Index进行合法性校验
        this.checkIndex(index);
        //根据指定位置获取节点对象
        Node<E> node = this.getNode(index);
        //获取节点对象中的元素
        E item = node.item;
        //判断当前节点是否为头节点
        if (node.prev == null) {
            this.head = node.next;
        } else {
            //完成当前节点的直接前驱节点与当前节点的直接后继节点的挂接
            node.prev.next = node.next;
        }
        //判断当前节点是否为尾节点
        if (node.next == null) {
            this.tail = node.prev;
        } else {
            //完成当前节点的直接后继节点与当前节点的直接前驱节点的挂接
            node.next.prev = node.prev;
        }
        //当前节点断掉与它直接前驱节点的连接
        node.prev = null;
        //当前节点断掉与它直接后继节点的连接
        node.next = null;
        node.item = null;
        //记录元素个数
        this.size--;
        return item;
    }

    /**
     * 在双向链表的头添加元素
     */
    public void addFirst(E element) {
        this.linkFirst(element);
    }

    /**
     * 在链表的头添加元素
     */
    private void linkFirst(E element) {
        //获取头节点对象
        Node head = this.head;
        Node node = new Node(null, element, head);
        //将新节点定义为头节点
        this.head = node;
        //判断当前链表中是否有节点如果没有，那么该节点既是头节点也是尾节点
        if (head == null) {
            this.tail = node;
        } else {
            head.prev = node;
        }
        //记录元素个数
        this.size++;
    }

    /**
     * 在链表的尾添加元素
     *
     * @param element
     */
    public void addLast(E element) {
        this.linkLast(element);
    }

    /**
     * 定义双向链表的节点对象
     */
    class Node<E> {
        E item;//记录元素
        Node<E> prev;//记录前一个节点对象
        Node<E> next;//记录下一个节点对象

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
