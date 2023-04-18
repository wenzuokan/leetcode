package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 209, 长度最小的子数组
 */
public class MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int slow=0;
        int temp=0;
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            temp+=nums[i];
            while (temp>=target){
                ans=Math.min(ans,i-slow+1);
                temp-=nums[slow];
                slow++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

}
