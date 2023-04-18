package com.leet.code.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 844,比较含退格的字符
 */
public class BackspaceCompare {

    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> deque=new LinkedList<>();
        Deque<Character> d=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='#'){
                deque.add(s.charAt(i));
            }else {
                if (deque.isEmpty()){
                    continue;
                }
                deque.removeLast();
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i)!='#'){
                d.add(t.charAt(i));
            }else {
                if (d.isEmpty()){
                    continue;
                }
                d.removeLast();
            }
        }
        while (!d.isEmpty()&&!deque.isEmpty()){
            if (d.removeLast()!=deque.removeLast()){
                return false;
            }
        }
        return d.isEmpty() && deque.isEmpty();
    }


}
