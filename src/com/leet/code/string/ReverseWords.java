package com.leet.code.string;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 151, 反转字符串中的单词
 */
public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder str = removeSpace(s);
        reverseString(str, 0, str.length() - 1);
        reverseEachWord(str);
        return str.toString();
    }

    private static StringBuilder removeSpace(String s) {//去除首位中间多余空格
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder str = new StringBuilder();
        while (start <= end) {
            if (s.charAt(start) != ' ' || str.charAt(str.length() - 1) != ' ') {
                str.append(s.charAt(start));
            }
            start++;
        }
        return str;
    }

    public static void reverseString(StringBuilder str, int start, int end) {//反转整个字符串
        while (start < end) {
            char temp = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder str) {//反转各个单词
        int start = 0;
        int end = 1;
        while (start < str.length()) {
            while (end < str.length() && str.charAt(end) != ' ') {
                end++;
            }
            reverseString(str, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

}
