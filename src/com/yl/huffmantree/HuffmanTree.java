package com.yl.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author candk
 * @Description
 * @date 3/24/21 - 9:38 AM
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = new int[]{13, 7, 8, 3, 29, 6, 1};
        Node node = createHuffmanTree(arr);
        preOrder(node);

    }

    /**
     * 创建赫夫曼树
     * @param arr
     */
    public static Node createHuffmanTree(int[] arr) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value, leftNode, rightNode);

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树！");
        }
    }
}


