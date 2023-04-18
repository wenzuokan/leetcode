package com.leet.code.dynamic.backpack;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 377,组合总和IV
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        //dp[i]: 凑成目标正整数为i的排列个数为dp[i]
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i=0;i<=target;i++){
            for (int j=0;j<nums.length;j++){
                if (i>=nums[j]){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
