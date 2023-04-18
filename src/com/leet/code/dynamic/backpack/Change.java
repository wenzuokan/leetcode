package com.leet.code.dynamic.backpack;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 518,零钱兑换II
 */
public class Change {

    public int change(int amount, int[] coins) {
       int[] dp=new int[amount+1];
       dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j=coins[i];j<amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
