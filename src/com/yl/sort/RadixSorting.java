package com.yl.sort;

import java.util.Arrays;

/**
 * @author candk
 * @Description 基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort），它是通过键值的各个位的值，
 * 将要排序的元素分配至某些“桶”中，达到排序的作用
 * 基数排序法属于效率高的稳定排序法
 * @date 3/16/21 - 2:04 PM
 */
public class RadixSorting {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        int max = getMax(arr);
        System.out.println(max);
//        int figure = getFigure(max);
        int figure = (max + "").length();
        System.out.println(figure);

        radixSort(arr, figure);
        System.out.println(Arrays.toString(arr));


    }

    /**
     *
     * @param arr
     */
    public static void radixSort(int[] arr, int figure){

        for (int a = 0; a < figure; a++) {
            int[][] buckets = new int[10][arr.length];
            int[] bucketElementCount = new int[10];
            int temp = (int) Math.pow(10, a);

            for (int item : arr) {
                int radix = item / temp % 10;
                buckets[radix][bucketElementCount[radix]] = item;
                bucketElementCount[radix]++;
            }

            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index] = buckets[i][j];
                    index++;
                }
            }
        }
    }

    public static int getMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    public static int getFigure(int num) {
        int temp = num;
        int figure = 0;
        while ((temp = temp / 10) % 10 > 0) {
            figure++;
        }
        return figure;
    }
}
