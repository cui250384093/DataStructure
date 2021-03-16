package com.yl.search;

import java.util.ArrayList;

/**
 * @author candk
 * @Description
 * @date 3/16/21 - 4:19 PM
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};

        int res = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println(res);

        ArrayList resList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(resList);
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

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static ArrayList binarySearch2(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right,findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {

            ArrayList<Integer> resList = new ArrayList<>();

            //向左寻找
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resList.add(temp);
                temp--;
            }
            resList.add(mid);

            //向右寻找
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resList.add(temp);
                temp++;
            }

            return resList;
        }
    }
}
