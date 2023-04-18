package com.leet.code.dynamic.backpack;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 279,完全平方数
 */
public class NumSquares {

    public int numSquares(int n) {
        int max=Integer.MAX_VALUE;
        int[] dp=new int[n+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for (int i=0;i*i<n;i++){
            for (int j=i*i;j<=n;j++){
                if (dp[j-i*i]!=max){
                    dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
}
