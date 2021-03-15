package com.yl.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @author candk
 * @Description 冒泡排序
 * 时间复杂度O(n²)
 * @date 3/15/21 - 10:11 AM
 */
public class BubbleSorting {

    @Test
    public void test1() {

        int[] arr = {10, 9, 8, 7, 6, 5};

        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr) {

        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }


}
