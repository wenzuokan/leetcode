package com.leet.code.nums;


/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 189,轮转数组
 */
public class Rotate {


    /**
     * nums = "----->-->"; k =3
     * result = "-->----->";
     *
     * reverse "----->-->" we can get "<--<-----"
     * reverse "<--" we can get "--><-----"
     * reverse "<-----" we can get "-->----->"
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums,int start,int end){
        for (int i=start,j=end;i<j;i++,j--){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
        }
    }


    /**
     * 我们可以使用额外的数组来将每个元素放至正确的位置。用
     * n 表示数组的长度，我们遍历原数组，将原数组下标为
     * i 的元素放至新数组下标为
     * (i+k)%n 的位置，最后将新数组拷贝至原数组即可
     *
     * @param nums
     * @param k
     */
    public void rotateII(int[] nums, int k) {
        int n=nums.length;
        int[] newArr=new int[n];
        for (int i=0;i<n;i++){
            newArr[(i+k)%n]=nums[i];//新的下标(i+k)%n
        }
        System.arraycopy(newArr,0,nums,0,n);
    }


}
