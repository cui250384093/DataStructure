package com.yl.sort;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author candk
 * @Description
 * @date 3/15/21 - 2:04 PM
 */
public class InsertSorting {

    public static void main(String[] args) {

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("Before: " + date1Str);
        System.out.println(Arrays.toString(arr));

        insertSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("Before: " + date2Str);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int data = arr[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    position = j;
                }
            }

            if (position != i) {
                delete(arr, i);
                insert(arr, position, data);
            }
        }
    }

    public static void insert(int[] arr, int position, int data) {
        for (int i = arr.length - 1; i > position; i--) {
            arr[i] = arr[i-1];
        }
        arr[position] = data;
    }

    public static void delete(int[] arr, int position) {
        for (int i = position; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }
}
