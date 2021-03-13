package com.yl.recursion;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * @author candk
 * @Description
 * @date 3/12/21 - 4:30 PM
 */
public class Maze {

    @Test
    public void testMap() {
        int[][] map = map(8, 7);
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][3] = 1;

        setWay(map,1,1);
        printMap(map);


    }

    public static int[][] map(int rowNum, int colNum) {
        int[][] map = new int[rowNum][colNum];
        for (int i = 0; i < colNum; i++) {
            map[0][i] = 1;
            map[rowNum - 1][i] = 1;
        }

        for (int i = 0; i < rowNum; i++) {
            map[i][0] = 1;
            map[i][colNum - 1] = 1;
        }

        return map;
    }

    public static void printMap(int[][] map) {
        for (int[] row : map) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map
     * @param i 从哪个位置开始找
     * @param j
     *          如果小球可以找到map[6][5],代表可以找到通路
     *          0 代表可以走，1 代表墙， 2 表示通路可以走， 3 表示该点走过但是走不通
     * @return 如果找到通路就返回true， 否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                //策略 下--》右--》上--》左
                map[i][j] =2;
                if (setWay(map, i+1, j)) {
                    return true;
                } else if (setWay(map, i, j+1)) {
                    return true;
                } else if (setWay(map, i-1, j)) {
                    return true;
                } else if (setWay(map, i, j-1)) {
                    return true;
                } else {
                    //说明改点走不通，是思路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //map[i][j] = 0,1,2
                return false;
            }
        }
    }
}
