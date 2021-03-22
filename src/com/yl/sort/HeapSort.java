package com.yl.sort;

/**
 * @author candk
 * @Description
 * @date 3/22/21 - 11:16 AM
 */
public class HeapSort {


    /**
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {

    }

    /**
     * 将一个数组（二叉树），调整为一个大顶堆
     * 完成将i对应的非叶子节点的树调整为大顶堆
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示堆多少个原始进行调整， length逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];
                arr[k] = temp;
                i = k;
            } else {
                break;
            }
        }

    }
}
