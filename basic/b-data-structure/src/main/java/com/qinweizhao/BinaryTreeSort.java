package com.qinweizhao;

/**
 * 基于二叉树结构实现元素排序处理的排序器
 *
 * @author qinweizhao
 * @since 2021-11-26
 */
public class BinaryTreeSort<E extends Integer> {
    private Node root;//存放树的根节点的地址

    public static void main(String[] args) {
        BinaryTreeSort<Integer> sort = new BinaryTreeSort<>();
        // 1,8,6,3,5,2
        sort.add(1);
        sort.add(8);
        sort.add(6);
        sort.add(3);
        sort.add(5);
        sort.add(2);
        sort.sort();
    }

    /**
     * 将元素添加到排序器中
     */
    public void add(E element) {
        //实例化结点对象
        Node<E> node = new Node<>(element);
        //判断当前二叉树中是否有根结点。如果没有那么新结点则为根结点
        if (this.root == null)
            this.root = node;
        else
            this.root.addNode(node);

    }

    /**
     * 对元素进行排序
     */
    public void sort() {
        //判断根结点是否为空
        if (this.root == null) return;
        this.root.inorderTraversal();
    }

    /**
     * 定义结点类
     */
    class Node<E extends Integer> {
        private E item;//存放元素
        private Node left;//存放左子树地址
        private Node right;//存放右子树地址

        Node(E item) {
            this.item = item;
        }

        /**
         * 添加结点
         */
        public void addNode(Node node) {
            //完成新结点中的元素与当前结点中的元素的判断.
            //如果新结点中的元素小于当前结点中的元素，那么新结点则放到当前结点的左子树中。
            if (node.item.intValue() < this.item.intValue()) {
                if (this.left == null)
                    this.left = node;
                else
                    this.left.addNode(node);
            } else {
                //如果新结点中的元素大于当前结点中的元素，那么新结点则放到当前结点的右子树中。
                if (this.right == null)
                    this.right = node;
                else
                    this.right.addNode(node);
            }
        }

        /**
         * 使用中序遍历二叉树
         */
        public void inorderTraversal() {
            //找到最左侧的那个结点
            if (this.left != null) this.left.inorderTraversal();
            System.out.println(this.item);
            if (this.right != null) this.right.inorderTraversal();
        }
    }
}
