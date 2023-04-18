package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 131,分割回文串
 */
public class Partition {

    List<List<String>> res=new ArrayList<>();
    Deque<String> deque=new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return res;
    }

    void backtracking(String s,int index){
        if (index>s.length()){
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i=index;i<s.length();i++){
            if (isPalindrome(s,index,i)){
                String str=s.substring(index,i);
                deque.addLast(str);
            }else {
                continue;
            }
            backtracking(s,i+1);
            deque.removeLast();
        }
    }

    boolean isPalindrome(String s,int start,int end){
        while (start<end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
