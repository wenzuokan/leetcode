package com.leet.code.dynamic.backpack;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 474,一和零
 */
public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        int[][] dp=new int[m+1][n+1];
        int one,zero;
        for (String str : strs) {
            zero = 0;
            one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m;i>=zero; i--) {
                for (int j=n;j>=one;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zero][j-one]+1);
                }
            }
        }
        return dp[m][n];
    }
}
