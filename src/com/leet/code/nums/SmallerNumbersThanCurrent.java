package com.leet.code.nums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 1365, 有多少小于当前数字的数字
 */
public class SmallerNumbersThanCurrent {


    //暴力解法
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (nums[i] > num) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * 可以定义一个新数组，将数组排个序。
     * 排序之后，其实每一个数值的下标就代表这前面有几个比它小的了
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrentII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            if (!map.containsKey(res[i])) {// 遇到了相同的数字，那么不需要更新该 number 的情况
                map.put(res[i], i);
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
