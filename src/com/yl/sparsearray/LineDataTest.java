package com.yl.sparsearray;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/4/21 - 2:08 PM
 */
public class LineDataTest {

    /**
     * 二维数组转稀疏数组的思路
     * 1. 遍历原始的二维数组，得到有效数据的个数sum
     * 2. 根据sum就可以创建稀疏数组的sparseArr和int[sum+1][3]
     * 3. 将二维数组的有效数据存入到稀疏数组
     *
     * 稀疏数组转原始的二维数组的思路
     * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr = int[11][11]
     * 2. 在读取稀疏数组后几行的数据，并赋给原始的二维数组即可。
     */
    @Test
    public void arrayToSparseArrayTest() {

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        int sum = 0;


        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

        int[][] sparseArr = new int[sum+1][3];

        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = 2;

        int flag = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[flag][0] = i;
                    sparseArr[flag][1] = j;
                    sparseArr[flag][2] = chessArr1[i][j];
                    flag++;
                }
            }
        }
        flag = 0;

        for (int[] arr1 : sparseArr) {
            for (int data : arr1) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void sparseArrToArrayTest() {
        int[][] sparseArr = new int[3][3];

        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = 2;

        sparseArr[1][0] = 1;
        sparseArr[1][1] = 2;
        sparseArr[1][2] = 1;

        sparseArr[2][0] = 2;
        sparseArr[2][1] = 3;
        sparseArr[2][2] = 2;

        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] arr1 : arr) {
            for (int data : arr1) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }
}
