package com.leet.code.dynamic;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 213,打家劫舍II
 */
public class RobII {

    /**
     * 对于一个数组，成环的话主要有如下三种情况：
     * 情况一：考虑不包含首尾元素
     * 情况二：考虑包含首元素，不包含尾元素
     * 情况三：考虑包含尾元素，不包含首元素
     * 此题在情况二和情况三下选取最大就行
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        return Math.max(robMethod(nums,1,nums.length-1),robMethod(nums,0,nums.length-2));
    }
    int robMethod(int[] nums,int start,int end){
        if (start==end){
            return nums[start];
        }
        int[] dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for (int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}
