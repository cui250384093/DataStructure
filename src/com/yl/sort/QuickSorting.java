package com.yl.sort;

import com.yl.util.Time;

import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 3/16/21 - 8:51 AM
 */
public class QuickSorting {

    /**
     * 快速排序思路分析
     * 1. int[arr.length / 2]作为基准值st，将比st小的置于st左边，st大的置于右边，形成两个小的序列
     * 2. 将左右两个序列重复1
     */

    public static void main(String[] args) {

        int[] arr = new int[80000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Time.showNowTime();
        quickSort(arr, 0, arr.length-1);
        Time.showNowTime();

    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        //临时变量作为交换使用
        int temp = 0;

        //while目的是让比pivot小的放到左边，比pivot大的放到右边
        while (l < r) {
            //在pivot左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot的左右两边的值，已经按照左边全部是小于等于pivot的值，右边全部是大于等于pivot的值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[l] = pivot, 前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果交换完后，发现arr[r] = pivot, 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        //如果l == r，必须l++，r--，否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(arr,left,r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr,left,r);
        }
    }
}
