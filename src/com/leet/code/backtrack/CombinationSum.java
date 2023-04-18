package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 39,组合总和
 */
public class CombinationSum {


    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return res;
    }
    public void backtracking(int[] candidates,int target,int index,int count){
        if (count==target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=index;i<candidates.length;i++){
            if (count+candidates[i]>target){
                break;
            }
            path.add(candidates[i]);
            backtracking(candidates,target,i,count+candidates[i]);
            path.removeLast();
        }
    }
}
