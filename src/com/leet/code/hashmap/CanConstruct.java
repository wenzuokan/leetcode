package com.leet.code.hashmap;


/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 383, 赎金信
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] word = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            word[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            word[ransomNote.charAt(i) - 'a']--;
            if (word[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
