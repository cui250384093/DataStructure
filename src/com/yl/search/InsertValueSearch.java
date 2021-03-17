package com.yl.search;

import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 3/17/21 - 9:46 AM
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 0));
    }

    /**
     *
     * @param arr 查找数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return 如果找到，返回索引，没有找到返回 -1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal){

        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        //得到mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid -1, findVal);
        } else {
            return mid;
        }
    }
}
