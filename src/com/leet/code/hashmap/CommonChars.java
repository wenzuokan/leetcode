package com.leet.code.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 1002, 查找共用字符
 */
public class CommonChars {

    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int[] word = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            word[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] count = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                count[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                word[k] = Math.min(count[k], word[k]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (word[i] != 0) {
                char c = (char) (i + 'a');
                res.add(String.valueOf(c));
                word[i]--;
            }
        }
        return res;
    }

}
