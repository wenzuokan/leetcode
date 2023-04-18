package com.leet.code.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 454, 四数相加II
 */
public class FourSumCount {

    /**
     * 1.首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
     * 2.遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
     * 3.定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
     * 4.在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
     * 5.最后返回统计值 count 就可以了
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for (int k : nums1) {
            for (int i : nums2) {
                if (map.containsKey(k + i)) {
                    map.put(k + i, map.get(k + i) + 1);
                } else {
                    map.put(k + i, 1);
                }
            }
        }
        for (int k : nums3) {
            for (int i : nums4) {
                int temp = k + i;
                if (map.containsKey(-temp)) {
                    count += map.get(-temp);
                }
            }
        }
        return count;
    }
}
