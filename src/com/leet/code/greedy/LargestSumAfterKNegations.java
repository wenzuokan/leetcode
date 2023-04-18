package com.leet.code.greedy;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 1005,k次取反后最大化的数组和
 */
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }
            result+=nums[i];
        }
        Arrays.sort(nums);
        if (k%2==0){
            return result;
        }else {
            return result-2*nums[0];
        }
    }
}
