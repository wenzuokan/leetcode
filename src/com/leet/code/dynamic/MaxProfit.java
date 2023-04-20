package com.leet.code.dynamic;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 121,买卖股票的最佳时期
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        //dp[i][0] 表示第i天持有股票所得最多现金
        //dp[i][1] 表示第i天不持有股票所得最多现金
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }
        return dp[prices.length-1][1];
    }

    public int maxProfitII(int[] prices) {
        int temp=Integer.MAX_VALUE;
        int max=0;
        for (int price : prices) {
            if (price < temp) {
                temp = price;
            } else if (price - temp > max) {
                max = price - temp;
            }
        }
        return max;
    }
}
