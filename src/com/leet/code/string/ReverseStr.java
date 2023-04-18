package com.leet.code.string;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 541,反转字符串II
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        char[] ch=s.toCharArray();
        for (int i=0;i<ch.length;i+=2*k){
            int start=i;
            int end=Math.min(ch.length-1,start+k-1);
            //只要让 i += (2 * k)，i 每次移动 2 * k 就可以了，然后判断是否需要有反转的区间
            while (start<end){
                char temp=ch[start];
                ch[start]=ch[end];
                ch[end]=temp;
                end--;
                start++;
            }
        }
        return new String(ch);
    }
}
