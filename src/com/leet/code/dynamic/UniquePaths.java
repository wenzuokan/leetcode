package com.leet.code.dynamic;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 62,不同路径
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i]=1;
        }
        dp[0][0]=0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
