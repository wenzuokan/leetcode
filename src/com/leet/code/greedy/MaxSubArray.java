package com.leet.code.greedy;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 53,最大子数组合
 */
public class MaxSubArray {

    /**
     * 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
     * 全局最优：选取最大“连续和”
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int result=Integer.MIN_VALUE;
        int count=0;
        for (int num : nums) {
            count += num;
            result = Math.max(result, count);
            if (count <= 0) {
                count =0;
            }
        }
        return result;
    }
}
