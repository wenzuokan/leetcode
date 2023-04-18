package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 78,子集
 */
public class Subsets {

    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }
    void backtracking(int[] nums,int index){
        res.add(new ArrayList<>(path));
        if (index>=nums.length){
            return;
        }
        for (int i=index;i<nums.length;i++){
            path.add(i);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
