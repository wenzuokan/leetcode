package com.leet.code.dynamic.backpack;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 322,零钱兑换
 *
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max=Integer.MAX_VALUE;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                if (dp[j-coins[i]]!=max){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==max?-1:dp[amount];
    }
}
