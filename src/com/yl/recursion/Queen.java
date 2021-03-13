package com.yl.recursion;

/**
 * @author candk
 * @Description
 * @date 3/13/21 - 2:18 PM
 */
public class Queen {

    int max = 8;
    int[] arr = new int[max];
    int count = 0;

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n+1);
            }
        }
    }
    /**
     * 判断是否一列或者同一斜线
     * @param n
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.println(queen.count);
    }
}
