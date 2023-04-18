package com.leet.code.greedy;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 455,分发饼干
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result=0;
        int j=0;
        for (int i=0;i<g.length&&j<s.length;i++){
            if (s[i]>=g[j]){
                j++;
                result++;
            }
        }
        return result;
    }
}
