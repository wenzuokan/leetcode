package com.leet.code.dynamic;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 746,使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    // 方式一：第一步不支付费用
    public int minCostClimbingStairs(int[] cost) {
        if (cost==null||cost.length==0){
            return 0;
        }
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
    // 方式二：第一步支付费用
    public int minCostClimbingStairsII(int[] cost) {
        int[] dp=new int[cost.length+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for (int i = 2; i <=cost.length; i++) {
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
