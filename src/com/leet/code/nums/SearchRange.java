package com.leet.code.nums;


/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 34,在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int left=getLeftBorder(nums,target);
        int right=getRightBorder(nums,target);

        if (left==-2||right==-2){
            return new int[]{-1,-1};
        }
        //target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
        if (right-left>1){
            return new int[]{left+1,right-1};
        }
        return new int[]{-1,-1};
    }

    static int getLeftBorder(int[] nums,int n){
        int left=0;
        int right=nums.length-1;
        int countLeft=-2;//记录一下countLeft没有被赋值的情况
        while (left<=right){
            int mid=left+((right-left)/2);
            if (nums[mid]>=n){
                right=mid-1;
                countLeft=right;
            }else {
                left=mid+1;
            }
        }
        return countLeft;
    }

    static int getRightBorder(int[] nums,int n){
        int left=0;
        int right=nums.length-1;
        int countRight=-2;
        while (left<=right){
            int mid=left+((right-left)/2);
            if (nums[mid]<=n){
                left=mid+1;
                countRight=left;
            }else {
                right=mid-1;
            }
        }
        return countRight;
    }

//    public static void main(String[] args) {
//        int[] arr=new int[]{5,7,7,8,8,10};
//        System.out.println(Arrays.toString(searchRange(arr,8)));
//    }
}
