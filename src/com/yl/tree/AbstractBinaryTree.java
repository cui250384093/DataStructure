package com.yl.tree;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/18/21 - 10:36 AM
 */
public interface AbstractBinaryTree<T> {

    public T getData();

    public void setData(T t);

    public AbstractBinaryTree<T> getleftChild();

    public AbstractBinaryTree<T> getRightChild();

    public void setRightChild(AbstractBinaryTree<T> tree);

    public void setLeftChild(AbstractBinaryTree<T> tree);

    public void removeLeftChild();

    public void removeRightChild();

    public void preOrderTreverse();

    public void inOrderTreverse();

    public void postOrderTreverse();

    public int getNodeCount();


}
