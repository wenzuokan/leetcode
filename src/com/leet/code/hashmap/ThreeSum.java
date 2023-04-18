package com.leet.code.hashmap;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 15, 三数之和
 */
public class ThreeSum {

    /**
     * 拿这个nums数组来举例，首先将数组排序，然后有一层for循环，i从下标0的地方开始，
     * 同时定一个下标left 定义在i+1的位置上，定义下标right 在数组结尾的位置上。
     * 依然还是在数组中找到 abc 使得a + b +c =0，我们这里相当于 a = nums[i]，b = nums[left]，c = nums[right]。
     * 接下来如何移动left 和right呢， 如果nums[i] + nums[left] + nums[right] > 0 就说明 此时三数之和大了，
     * 因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。
     * 如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，
     * left 就向右移动，才能让三数之和大一些，直到left与right相遇为止
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (nums[i]>0){ // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
                return ans;
            }
            if (i>0&&nums[i]==nums[i-1]){//去重
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int temp=nums[i]+nums[left]+nums[right];
                if (temp>0){
                    right--;
                }else if (temp<0){
                    left++;
                }else {
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    right--;
                    left++;
                }
            }
        }
        return ans;
    }
}
