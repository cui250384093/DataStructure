package com.yl.sort;

import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 3/22/21 - 11:16 AM
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 0, 1, 7, 11, 10, 21};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将一个数组（二叉树），调整为一个大顶堆
     * 完成将i对应的非叶子节点的树调整为大顶堆
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个原始进行调整， length逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //当for结束收，我们已经将以i为父节点的树的最大值，放在了堆顶（局部）
        arr[i] = temp;

    }
}
