package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 27, 移除元素
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];

            }
        }
        return slow;
    }


    /**
     * 如果左指针left指向的元素等于val，此时将右指针right指向的元素复制到left位置，
     * 然后右指针right左移一位。如果赋值过来的元素恰好也等于val
     * 可以继续把右指针right指向的元素的值赋值过来，
     * 直到左指针指向的元素的值不等于val 为止。
     * 当左指针left 和右指针right 重合的时候，左右指针遍历完数组中所有的元素。
     * @param nums
     * @param val
     * @return
     */
    public int removeElementII(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
