package com.leet.code.backtrack.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 22, 括号生成
 */
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();
    StringBuilder str = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n);
        return res;
    }

    void backtracking(int left, int right, int max) {
        if (str.length() == max * 2) {
            res.add(str.toString());
            return;
        }

        if (left < max) {
            str.append('(');
            backtracking(left + 1, right, max);
            str.deleteCharAt(str.length() - 1);
        }
        if (right < left) {
            str.append(')');
            backtracking(left, right + 1, max);
            str.deleteCharAt(str.length() - 1);
        }

    }
}
