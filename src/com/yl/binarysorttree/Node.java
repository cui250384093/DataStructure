package com.yl.binarysorttree;

/**
 * @author candk
 * @Description
 * @date 3/25/21 - 11:30 AM
 */
public class Node {

    int value;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }

        //递归添加
        if(node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value) {
        if (this.left != null && this.left.value == value) {
            return this;
        } else if (this.right != null && this.right.value == value) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if ((value >= this.value && this.right != null)){
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public Node subTreeMinValue() {
        if (this.left == null) {
            return this;
        } else {
            return this.left.subTreeMinValue();
        }
    }
}
