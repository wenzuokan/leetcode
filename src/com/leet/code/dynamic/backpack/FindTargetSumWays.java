package com.leet.code.dynamic.backpack;


import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 494,目标和
 */
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
       int sum= Arrays.stream(nums).sum();
       int len=(sum+target)/2;
       if (target<0&&sum<-target){
           return 0;
       }
       if ((target+sum)%2!=0){
           return 0;
       }
       if (len<0){
           len=-len;
       }
       int[] dp=new int[len+1];
       dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j=target;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[len];
    }
}
