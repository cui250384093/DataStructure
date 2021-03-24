package com.yl.huffmancoding;

import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 3/24/21 - 3:08 PM
 */
public class Node implements Comparable<Node> {

    int weight;
    Byte data;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int weight, Byte data) {
        this.weight = weight;
        this.data = data;
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
                "weight=" + weight +
                ", data=" + data +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
