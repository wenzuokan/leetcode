package com.leet.code.dynamic;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 343,整数拆分
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        //dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
        int[] dp=new int[n+1];
        dp[2]=1;
        for (int i = 3; i <=n; i++) {
            for (int j=1;j<i-j;j++){
            dp[i]=Math.max(Math.max(dp[i],j*(i-j)),dp[i-j]*j);
            }
        }
        return dp[n];
    }

}
