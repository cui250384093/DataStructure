package com.yl.sort;

import com.yl.util.Time;

import java.util.Arrays;


/**
 * @author candk
 * @Description 希尔排序
 * @date 3/15/21 - 3:39 PM
 */
public class ShellSorting {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println(Arrays.toString(arr));

        Time.showNowTime();
        shellSort1(arr);

        System.out.println(Arrays.toString(arr));
        Time.showNowTime();
    }

    /**
     * 交换法
     * @param arr
     */
    public static void shellSort1(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j+gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }

            }
        }
    }

    /**
     * 移位法
     * @param arr
     */
    public static void shellSort2(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                 int j = i;
                 int temp = arr[j];
                 if (arr[j] < arr[j - gap]) {
                     while (j - gap >= 0 && temp < arr[j - gap]) {
                         arr[j] = arr[j - gap];
                         j -= gap;
                     }
                     arr[j] = temp;
                 }

            }
        }
    }
}
