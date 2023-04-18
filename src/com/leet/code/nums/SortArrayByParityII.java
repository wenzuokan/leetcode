package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 922, 按奇偶排序数组II
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;
        while (even < nums.length && odd < nums.length) {
            if (nums[even] % 2 == 1 && nums[odd] % 2 == 0) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even += 2;
                odd += 2;
            } else if (nums[even] % 2 == 0 && nums[odd] % 2 == 0) {//奇数不对
                even += 2;
            } else if (nums[even] % 2 == 1 && nums[odd] % 2 == 1) {//偶数不对
                odd += 2;
            } else {
                even += 2;
                odd += 2;
            }
        }
        return nums;
    }
}
