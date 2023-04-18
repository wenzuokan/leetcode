package com.leet.code.string;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 剑指 Offer 58 - II. 左旋转字符串
 */
public class ReverseLeftWords {


    /**
     * 1.反转区间为前n的子串
     * 2.反转区间为n到末尾的子串
     * 3.反转整个字符串
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        String s1 = reverseStr(s, 0, n - 1);
        String s2 = reverseStr(s1, n, s1.length() - 1);
        s=reverseStr(s2,0,s2.length()-1);
        return s;
    }

    private static String reverseStr(String s,int start,int end){
        char[] ch=s.toCharArray();
        while (start<end){
            char temp=s.charAt(start);
            ch[start]=s.charAt(end);
            ch[end]=temp;
            start++;
            end--;
        }
        return new String(ch);
    }
}
