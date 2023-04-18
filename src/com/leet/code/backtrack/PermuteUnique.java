package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 47, 全排列II
 */
public class PermuteUnique {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//数层去重需要数组是有序数组
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {//数层去重
                continue;
            }
            if (!used[i]) {//树枝去重
                path.add(nums[i]);
                used[i] = true;
                backtracking(nums, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
