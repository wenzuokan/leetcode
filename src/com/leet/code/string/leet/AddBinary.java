package com.leet.code.string.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 67,二进制求和
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        Deque<Character> res=new LinkedList<>();
        if (a.length()<b.length()){
            String temp=a;
            a=b;
            b=temp;
        }
        int i=a.length()-1;
        int j=b.length()-1;
        boolean flag=false;
        while (j>=0){
            if (a.charAt(i)=='0'&&b.charAt(j)=='0'){
                if (flag){
                    res.push('1');
                    flag=false;
                }else {
                    res.push('0');
                }
            }else if (a.charAt(i)=='1'&&b.charAt(j)=='1'){
                if (flag){
                    res.push('1');
                }else {
                 res.push('0');
                 flag=true;
                }
            }else {
                if (flag){
                    res.push('0');
                }else {
                    res.push('1');
                }
            }
            j--;
            i--;
        }
        while (i>=0){
            if (flag&&a.charAt(i)=='1'){
                res.push('0');
            }else if (flag&&a.charAt(i)=='0'){
                res.push('1');
                flag=false;
            }else {
                res.push(a.charAt(i));
            }
            i--;
        }
        if (flag){
            res.push('1');
        }
        StringBuilder str=new StringBuilder();
        while (!res.isEmpty()){
            str.append(res.poll());
        }
        return str.toString();
    }

}
