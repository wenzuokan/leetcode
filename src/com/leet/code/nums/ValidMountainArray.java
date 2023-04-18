package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 941, 有效的山脉数组
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        // 如果left或者right都在起始位置，说明不是山峰
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }

    /**
     * 线性扫描
     *
     * @param arr
     * @return
     */
    public boolean validMountainArrayII(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int len = 0;
        while (len + 1 < arr.length && arr[len] < arr[len + 1]) {
            len++;
        }
        if (len == 0 || len == arr.length - 1) {
            return false;
        }
        int len2 = arr.length - 1;
        while (len2 > 0 && arr[len2] < arr[len2 - 1]) {
            len2--;
        }
        return len == len2;
    }

}
