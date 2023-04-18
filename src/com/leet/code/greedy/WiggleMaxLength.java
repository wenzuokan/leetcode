package com.leet.code.greedy;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 376,摆动序列
 */
public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        int pre=0;
        int cur=0;
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            cur=nums[i]-nums[i-1];
            if ((cur>0&&pre<=0)||(cur<0&&pre>=0)){
                count++;
                pre=cur;
            }
        }
        return count;
    }
}
