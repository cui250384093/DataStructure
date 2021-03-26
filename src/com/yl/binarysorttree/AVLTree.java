package com.yl.binarysorttree;

/**
 * @author candk
 * @Description
 * @date 3/25/21 - 4:26 PM
 */
public class AVLTree extends BinarySortTree {



    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }

        avlTree.infixOrder();



    }

}
