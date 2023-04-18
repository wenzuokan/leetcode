package com.leet.code.string;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 344,反转字符串
 */
public class ReverseString {


    public static void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while (left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
