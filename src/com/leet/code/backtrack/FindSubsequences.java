package com.leet.code.backtrack;

import java.util.*;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 491, 递增子序列
 */
public class FindSubsequences {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }
    void backtracking(int[] nums, int index) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
            //这里不return，要取树上节点
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = index; i < nums.length; i++) {
            if (!path.isEmpty()&&nums[i]<path.getLast()){
                continue;
            }
            if (map.getOrDefault(nums[i],0)>=1){
                continue;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
