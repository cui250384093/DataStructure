package com.yl.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 3/15/21 - 1:35 PM
 */
public class SelectSorting {

    @Test
    public void test1() {
        int[] arr = {10,9,8,7,6,5,4,3};
        System.out.println(Arrays.toString(arr));

        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 将得到的每轮循环的最小值与arr[i]交换，循环arr.length-1轮
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int swap;
        for (int i = 0; i < arr.length - 1; i++) {
            swap = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[swap] > arr[j]) {
                    swap = j;
                }
            }
            int temp = 0;
            if (swap != i) {
                temp = arr[swap];
                arr[swap] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
