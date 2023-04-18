package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 90,子集II
 */
public class SubsetsWithDup {

    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length==0){
            res.add(path);
            return res;
        }
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backtracking(nums,0,used);
        return res;
    }
    void backtracking(int[] nums,int index,boolean[] used){
        res.add(new ArrayList<>(path));
        if (index>=nums.length){
            return;
        }
        for (int i=index;i<nums.length;i++){
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            path.add(i);
            used[i]=true;
            backtracking(nums,i+1,used);
            used[i]=false;
            path.removeLast();
        }
    }
}
