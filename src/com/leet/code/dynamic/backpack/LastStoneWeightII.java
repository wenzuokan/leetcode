package com.leet.code.dynamic.backpack;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 1049,最后一块石头的重量II
 */
public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int sum= Arrays.stream(stones).sum();
        int target=sum>>1;
        //dp[j]表示容量（这里说容量更形象，其实就是重量）为j的背包，最多可以背最大重量为dp[j]
        int[] dp=new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[target];
    }
}
