package com.leet.code.greedy;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 55,跳跃游戏
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return nums[0]>=1;
        }
        int rage=nums[0];
        for (int i=0;i<=rage;i++){
            rage=Math.max(rage,i+nums[i]);
            if (rage>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
