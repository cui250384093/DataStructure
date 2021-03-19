package com.yl.tree;

/**
 * @author candk
 * @Description
 * @date 3/19/21 - 3:08 PM
 */
public class ArrayBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder(0);
        arrayBinaryTree.midOrder(0);
        arrayBinaryTree.postOrder(0);

    }

    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 顺序存储二叉树 -》 前序遍历
     * @param index 数组下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        System.out.println(arr[index]);

        if (index * 2 + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        if (index * 2 + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        if (index * 2 + 1 < arr.length) {
            midOrder(2 * index + 1);
        }

        System.out.println(arr[index]);

        if (index * 2 + 2 < arr.length) {
            midOrder(2 * index + 2);
        }
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }

        if (index * 2 + 1 < arr.length) {
            postOrder(2 * index + 1);
        }

        if (index * 2 + 2 < arr.length) {
            postOrder(2 * index + 2);
        }

        System.out.println(arr[index]);
    }
}
