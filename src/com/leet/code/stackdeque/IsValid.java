package com.leet.code.stackdeque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 20,有效的括号
 */
public class IsValid {

    public boolean isValid(String s) {
        Deque<Character> deque=new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
           ch=s.charAt(i);
           if (ch=='('){
               deque.push(')');
           }else if (ch=='{'){
               deque.push('}');
           }else if (ch=='['){
               deque.push(']');
           }else if (deque.isEmpty()||deque.peek()!=ch){
               return false;
           }else {
               deque.pop();
           }
        }
        return deque.isEmpty();
    }
}
