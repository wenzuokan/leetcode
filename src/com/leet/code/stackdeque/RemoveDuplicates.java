package com.leet.code.stackdeque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 1047,删除字符串中的所有相邻重复项
 */
public class RemoveDuplicates {

    public static String removeDuplicates(String s) {
        Deque<Character> deque=new LinkedList<>();
        StringBuilder str=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!deque.isEmpty()&&deque.peek()==s.charAt(i)){
                deque.pop();
            }else {
                deque.push(s.charAt(i));
            }
        }
        while (!deque.isEmpty()){
            str.append(deque.removeLast());
        }
        return str.toString();
    }

}
