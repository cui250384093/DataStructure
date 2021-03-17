package com.yl.search;

import java.util.Arrays;

/**
 * @author candk
 * @Description 斐波那契查找
 * 斐波那契数列 {1,1,2,3,5,8,13,21,34,55...n+2 = n + n+1} 无限接近0.618
 * @date 3/17/21 - 10:02 AM
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int res = fibonacciSearch(arr, 123);
        System.out.println(res);

    }


    /**
     * 非递归的斐波那契查找
     * @param arr
     * @param findVal
     * @return
     */
    public static int fibonacciSearch(int[] arr, int findVal){
        int low = 0;
        int high = arr.length - 1;
        //斐波那契分割数值数值下标
        int k = 0;
        int mid = 0;
        int[] fib = fib(arr.length);

        while (high > fib[k] - 1) {
            k++;
        }

        //因为f[k] 值可能大于arr的长度，因此我们需要石永红Arrays构造一个新的数值，并指向arr[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, fib[k]);
        //实际需求使用a数组最后的数组填充temp
        //{1, 8, 10, 89, 1000, 1234} -> {1, 8, 10, 89, 1000, 1234, 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //
        while (low <= high) {
            mid = low + fib[k-1] - 1;
            if (findVal < temp[mid]){
                high = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid < high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }

    /**
     * mid = low + F(k-1)-1, 需要用到斐波那契数列，因此先获取一个斐波那契数列
     * @param maxSize
     * @return
     */
    public static int[] fib(int maxSize) {
        int[] fibs = new int[maxSize];
        fibs[0] = 1;
        fibs[1] = 1;

        for (int i = 2; i < maxSize; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }

        return fibs;
    }
}
