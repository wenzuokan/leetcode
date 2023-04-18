package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 59, 螺旋矩阵II
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int loop = 0;//循环次数
        int start = 0;// 每次循环的开始点(start, start)
        int offset = 1;
        int i, j;

        while (loop++ < n / 2) {
            for (j = start; j < n - loop; j++) {
                res[start][j] = offset++;
            }
            for (i = start; i < n - loop; i++) {
                res[i][j] = offset++;
            }
            for (; j >= loop; j--) {
                res[i][j] = offset++;
            }
            for (; i >= loop; i--) {
                res[i][j] = offset++;
            }
            start++;
        }
        if (n % 2 == 1) {
            res[start][start] = offset;
        }
        return res;
    }

}
