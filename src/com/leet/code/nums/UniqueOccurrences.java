package com.leet.code.nums;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 1207, 独一无二的出现次数
 */
public class UniqueOccurrences {

    /**
     * 首先使用哈希表记录每个数字的出现次数；随后再利用新的哈希表，统计不同的出现次数的数目。
     * 如果不同的出现次数的数目等于不同数字的数目，则返回true，否则返回  false。
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);//记录每个元素出现的次数
        }
        Set<Integer> times = new HashSet<>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            times.add(x.getValue());
        }

        return map.size()==times.size();
    }
}
