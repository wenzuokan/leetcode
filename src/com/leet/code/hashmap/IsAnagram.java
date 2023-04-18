package com.leet.code.hashmap;

import java.util.Arrays;


/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 242, 有效的字母异位词
 */
public class IsAnagram {

    //通过把字符串转换为数组排序然后进行判断
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        Arrays.sort(sC);
        Arrays.sort(tC);
        return Arrays.equals(sC, tC);
    }

    public boolean isAnagramII(String s, String t) {
      int[] word=new int[26];
      for (int i=0;i<s.length();i++){
          word[s.charAt(i)-'a']++;
      }
      for (int i=0;i<t.length();i++){
          word[t.charAt(i)-'a']--;
      }
      for (int count:word){
          if (count!=0){
              return false;
          }
      }
      return true;
    }
}
