package com.yl.tree;

import java.util.function.BinaryOperator;

/**
 * @author candk
 * @Description
 * 1. 数组存储方式的分析
 *  优点：通过下标方式访问元素，速度快。对于有序数组，可以通过二分查找提高检索速度
 *  缺点：如果要检索具体某个值，或者插入会整体移动，效率较低
 * 2. 链式存储方式的分析
 *  优点：一定程度上对存储方式有优化（比如：插入一个节点，只需要将插入节点，链接到链表即可，删除效率也很好）
 *  缺点：在进行检索时，效率仍然较低，比如（检索某个值，需要从头节点开始遍历）
 * 3. 树存储方式的分析
 *  可以提高数据存储，读取的效率，既可以保证数据的检索速度，同时也可以保证数据的插入，删除和修改的速度。
 *
 * 前序遍历 - 先输出父节点，再遍历左子树和右子树
 *  1. 先输出当前节点（初始的时候是root节点）
 *  2. 如果左子节点不为空，则递归继续前序遍历
 *  3. 如果右子节点不为空，则递归继续前序遍历
 * 中序遍历 - 先遍历左子树，再输出父节点，再遍历右子树
 *  1. 如果当前节点的左子节点不为空，则递归中序遍历
 *  2. 输出当前节点
 *  3. 如果当前节点的右子节点不为空，则递归中序遍历
 * 后序遍历 - 先遍历左子树，再遍历右子树，最后输出父节点
 *  1. 如果当前节点的左子节点不为空，则递归后序遍历
 *  2. 如果当前节点的右子节点不为空，则递归后序遍历
 *  3. 输出当前节点
 * 小结：输出父节点的顺序，确定是前序，中序还是后序
 *
 *
 *
 * @date 3/18/21 - 9:18 AM
 */
public class BinaryTree<T> implements AbstractBinaryTree<T> {

    private T root;
    private BinaryTree<T> lTree;
    private BinaryTree<T> rTree;

    public BinaryTree() {

    }

    public BinaryTree(T root) {
        this.root = root;
    }

    public BinaryTree(T root, BinaryTree<T> lTree, BinaryTree<T> rTree) {
        this.root = root;
        this.lTree = lTree;
        this.rTree = rTree;
    }


    @Override
    public T getData() {
        return root;
    }

    @Override
    public void setData(T t) {
        root = t;
    }

    @Override
    public AbstractBinaryTree<T> getleftChild() {
        return lTree;
    }

    @Override
    public AbstractBinaryTree<T> getRightChild() {
        return lTree;
    }

    @Override
    public void setRightChild(AbstractBinaryTree<T> tree) {
        rTree = (BinaryTree<T>) tree;
    }

    @Override
    public void setLeftChild(AbstractBinaryTree<T> tree) {
        lTree = (BinaryTree<T>) tree;
    }

    @Override
    public void removeLeftChild() {
        lTree = null;
    }

    @Override
    public void removeRightChild() {
        rTree = null;
    }

    @Override
    public void preOrderTreverse() {

        if (root != null) {
            System.out.println(root);
        }

        if (lTree != null) {
            lTree.preOrderTreverse();
        }

        if (rTree != null) {
            rTree.preOrderTreverse();
        }
    }

    @Override
    public void inOrderTreverse() {

        if (lTree != null) {
            lTree.preOrderTreverse();
        }

        if (root != null) {
            System.out.println(root);
        }

        if (rTree != null) {
            rTree.preOrderTreverse();
        }
    }

    @Override
    public void postOrderTreverse() {

        if (lTree != null) {
            lTree.preOrderTreverse();
        }

        if (rTree != null) {
            rTree.preOrderTreverse();
        }

        if (root != null) {
            System.out.println(root);
        }
    }

    @Override
    public int getNodeCount() {

        int count = 0;

        if (root != null) {
            count ++;
        }
        if (lTree != null) {
            count += lTree.getNodeCount();
        }
        if (rTree != null) {
            count += rTree.getNodeCount();
        }
        return count;
    }
}
