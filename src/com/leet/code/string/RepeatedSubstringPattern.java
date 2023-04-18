package com.leet.code.string;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 459, 重复的子字符串
 * 前缀表：记录下标i之前（包括i）的字符串中，有多大长度的相同前缀后缀。
 */
public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] ch = s.toCharArray();
        int[] next = new int[len + 1];
        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && ch[i] != ch[j + 1]) {
                // 匹配成功，j往后移
                j = next[j];
            }
            if (ch[i] == ch[j + 1]) {
                j++;
            }
            // 更新 next 数组的值
            next[i] = j;
        }
        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }

}
