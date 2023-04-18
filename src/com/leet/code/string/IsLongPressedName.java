package com.leet.code.string;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 925, 长按键入
 */
public class IsLongPressedName {

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        if (name.charAt(i) != typed.charAt(j) || name.length() > typed.length()) {
            return false;
        }
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (name.charAt(i) != typed.charAt(j) && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        if (i < name.length()) {//name没有匹配完情况
            return false;
        }
        while (j < typed.length()) {
            if (typed.charAt(j) == typed.charAt(j - 1)) {//typed没有匹配完情况
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    //简洁版
    public static boolean isLongPressedNameII(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
