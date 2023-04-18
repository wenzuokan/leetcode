package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 977, 有序数组的平方
 */
public class SortedSquares {


    /**
     * 可以使用两个指针分别指向位置0和n−1，
     * 每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1, k = res.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[k] = nums[left] * nums[left];
                k--;
                left++;
            } else {
                res[k] = nums[right] * nums[right];
                k--;
                right--;
            }
        }
        return res;
    }
}
