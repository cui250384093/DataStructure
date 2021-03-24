package com.yl.huffmantree;

/**
 * @author candk
 * @Description HuffmanTree 结点
 * @date 3/24/21 - 9:38 AM
 */
public class Node implements Comparable<Node>{

    int value;
    char c;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, char c) {
        this.value = value;
        this.c = c;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", c=" + c +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
