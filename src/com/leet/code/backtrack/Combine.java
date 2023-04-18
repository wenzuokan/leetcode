package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 77,组合
 */
public class Combine {

    static List<List<Integer>> result=new LinkedList<>();
    static LinkedList<Integer> path=new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }
    public static void backtracking(int n,int k,int index){
        if (path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n-(k-path.size())+1; i++) {
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
}
