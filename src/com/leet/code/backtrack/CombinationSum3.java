package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 216, 组合总和III
 */
public class CombinationSum3 {


    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1,0);
        return result;
    }

    private void backtracking(int k, int n, int index, int count) {
        if (count>n){
            return;
        }
        if (path.size()==k){
            if (count==n){
                result.add(new ArrayList<>(path));
                return;
            }
        }
        for (int i=index;i<=9-(k- path.size())+1;i++){
            path.add(i);
            count+=i;
            backtracking(k,n,i+1,count);
            path.removeLast();
            count-=i;
        }
    }
}
