package com.leet.code.string;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 28, 找出字符串中第一个匹配项的下标
 * 前缀表：记录下标i之前（包括i）的字符串中，有多大长度的相同前缀后缀。
 */
public class StrStr {

    /**
     * 基于滑动窗口算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int n = haystack.length();
        if (n < m) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < n - m + 1) {
            while (i < n && haystack.charAt(i) != needle.charAt(j)) {//找首字母相等
                i++;
            }
            if (i == n) {//没有首字母相等
                return -1;
            }
            i++;
            j++;
            while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {//找到
                return i - j;
            } else {
                i -= j - 1;
                j = 0;
            }
        }
        return -1;
    }


    /**
     * KMP,前缀表
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStrII(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >=0 && needle.charAt(j+1) != haystack.charAt(i)) {
                j = next[j];
            }
            if (needle.charAt(j+1) == haystack.charAt(i)) {
                j++;
            }
            if (j == next.length-1) {//找到
                return i - next.length + 1;
            }
        }
        return -1;
    }

    private static void getNext(int[] next, String s) {
       int j=-1;
       next[0]=j;
       for (int i=1;i<s.length();i++){
           while (j>=0&&s.charAt(i)!=s.charAt(j+1)){
               j=next[j];
           }
           if (s.charAt(i) == s.charAt(j + 1)) {
               j++;
           }
           next[i]=j;
       }
        System.out.println(Arrays.toString(next));
    }


}
