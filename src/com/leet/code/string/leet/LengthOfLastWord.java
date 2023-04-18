package com.leet.code.string.leet;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 58,最后一个单词长度
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int len=0;
        int i=s.length()-1;
        while (s.charAt(i)==' '){
            i--;
        }
        while (i>=0&&s.charAt(i)!=' '){
            i--;
            len++;
        }
        return len;
    }

}
