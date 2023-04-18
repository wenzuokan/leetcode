package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 35, 搜索插入位置
 */
public class SearchInsert {


    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
