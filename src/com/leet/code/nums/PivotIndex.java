package com.leet.code.nums;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 724,寻找数组的中心下标
 */
public class PivotIndex {


    public  int pivotIndex(int[] nums) {
        int count=countNums(nums,nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (2*countNums(nums,i)==count-nums[i]){
                return i;
            }
        }

        return -1;
    }

   public  int countNums(int[] nums,int n){
        int count=0;
        for(int i=0;i<n;i++){
            count+=nums[i];
        }
        return count;
   }

//    public static void main(String[] args) {
//        int[] arr=new int[]{1,7,3,6,5,6};
//        System.out.println(pivotIndex(arr));
//    }


    //简洁版
    public  int pivotIndexII(int[] nums) {
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        int leftSum=0;
        int rightSum=0;
        for (int i = 0; i < nums.length; i++) {
            leftSum+=nums[i];
            rightSum=sum-leftSum+nums[i];
            if (leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
}
