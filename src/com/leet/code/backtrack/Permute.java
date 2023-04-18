package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 46,全排列
 */
public class Permute {

    static List<List<Integer>> res=new ArrayList<>();
    static LinkedList<Integer> path=new LinkedList<>();
    static public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        backtracking(nums,used);
        return res;
    }
    static void backtracking(int[] nums,boolean[] used){
        if (path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            backtracking(nums,used);
            used[i]=false;
            path.removeLast();
        }
    }

}
