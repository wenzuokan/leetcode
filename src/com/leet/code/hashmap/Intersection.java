package com.leet.code.hashmap;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 349, 两个数组的交集
 */
public class Intersection {

    //set结构（set的add方法是不会添加重复数据）
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }
        Set<Integer> setOut = new HashSet<>();
        for (int j : nums2) {
            if (set.contains(j)) {
                setOut.add(j);
            }
        }
        int[] res = new int[setOut.size()];
        int j = 0;
        for (int i : setOut) {
            res[j++] = i;
        }
        return res;
    }
}
