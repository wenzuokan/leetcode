package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 283, 移动零
 */
public class MoveZeroes {

    //双指针，类似移除元素
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        for (int i = fast; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        for (int j = slow; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroesII(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k++;
            } else {
                if (k > 0) {
                    nums[i - k] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}
