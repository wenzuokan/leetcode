package com.leet.code.dynamic;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 70,爬楼梯
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int climbStairsBP(int n) {
        int[] dp=new int[n+1];
        int[] count={1,2};
        dp[0]=1;
        for (int i=1;i<=n;i++){
            for (int j=0;j<count.length;j++){
                if (i>=count[j]){
                    dp[i]+=dp[i-count[j]];
                }
            }
        }
        return dp[n];
    }
}
