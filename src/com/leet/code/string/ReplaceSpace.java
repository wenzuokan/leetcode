package com.leet.code.string;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 剑指 Offer 05. 替换空格
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder ch = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ch.append("%20");
            } else {
                ch.append(s.charAt(i));
            }
        }
        return ch.toString();
    }

    /**
     * 首先扩充数组到每个空格替换成"%20"之后的大小。
     * 然后从后向前替换空格，也就是双指针法
     *
     * @param s
     * @return 不使用额外辅助空间
     */
    public String replaceSpaceII(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("   ");
            }
        }

        if (str.length() == 0) {
            return s;
        }

        int left = s.length() - 1;
        s += str.toString();
        int right = s.length() - 1;
        char[] ch = s.toCharArray();
        while (left > 0) {
            if (ch[left] == ' ') {
                ch[right--] = '0';
                ch[right--] = '2';
                ch[right] = '%';
            } else {
                ch[right] = ch[left];
            }
            right--;
            left--;
        }
        return new String(ch);
    }
}
