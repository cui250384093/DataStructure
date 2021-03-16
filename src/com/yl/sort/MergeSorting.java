package com.yl.sort;

import java.util.Arrays;

/**
 * @author candk
 * @Description 并归排序--分治
 * 归并排序（merge-sort）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide and conquer）策略（分治方法将问题分（divide）成一些小的问题然后递归求解，而
 * 治（conquer）的阶段，将分的阶段得到的各答案“修补”在一起，即分而治之）
 * @date 3/16/21 - 9:43 AM
 */
public class MergeSorting {

    public static void main(String[] args) {
       int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分+合方法
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     *
     * @param arr 原始序列
     * @param left 左边有序序列的原始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左边有序序列的初始索引
        int i = left;
        //右边有序序列的初始索引
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;

        //先把左右两边（有序）的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        //将有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //将temp数组的原始拷贝到arr,并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
