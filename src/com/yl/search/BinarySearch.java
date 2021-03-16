package com.yl.search;

/**
 * @author candk
 * @Description
 * @date 3/16/21 - 4:19 PM
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};

        int res = binarySearch(arr, 0, arr.length, 11);
        System.out.println(res);

    }

    /**
     *
     * @param arr 查找数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return 找到则返回索引，没找到返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right,findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
