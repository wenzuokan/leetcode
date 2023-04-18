package com.leet.code.string.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 3,无重复字符的最长字串
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口
     * @param s
     * @return
     * 比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，
     * 当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列
     * 如何移动？
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解
     */
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        int res=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (map.containsKey(ch)){
                count=Math.max(count,map.get(ch)+1);
            }
            res=Math.max(res,i-count+1);
            map.put(ch,i);
        }
        return res;
    }
}
