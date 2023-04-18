package com.leet.code.stackdeque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 150,逆波兰表达式
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque=new LinkedList<>();
        for (String s:tokens){
            if ("+".equals(s)){
                deque.push(deque.pop()+deque.pop());
            }else if ("-".equals(s)){
                deque.push(-deque.pop()+deque.pop());
            }else if ("*".equals(s)){
                deque.push(deque.pop()*deque.pop());
            }else if ("/".equals(s)){
                int t1=deque.pop();
                int t2=deque.pop();
                deque.push(t2/t1);
            }else {
                deque.push(Integer.valueOf(s));
            }
        }
        return deque.pop();
    }

}
