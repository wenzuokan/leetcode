package com.leet.code.greedy;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 45, 跳跃游戏II
 */
public class Jump {

    public int jump(int[] nums) {
        if (nums == nums || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int cur = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                count++;
                break;
            }
            if (i == cur) {
                cur = max;
                count++;
            }
        }
        return count;
    }
}
