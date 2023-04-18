package com.leet.code.stackdeque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 239,滑动窗口最大值
 */
public class MaxSlidingWindow {

    //利用双端队列手动实现单调队列
    /**
     * 用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
     * 单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        int[] res=new int[nums.length-k+1];
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (!deque.isEmpty()&&deque.peek()<i-k+1){
                deque.pop();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if (i>=k-1){
                res[index++]=nums[deque.peek()];
            }
        }
        return res;
    }

    //单调队列
    public static int[] maxSlidingWindowII(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        for (int i=0;i<k;i++){
            while (!deque.isEmpty()&&nums[i]>=deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        res[0]=nums[deque.peekFirst()];
        for (int i=k;i<nums.length;i++){
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            res[i-k+1]=nums[deque.peekFirst()];
        }
        return res;
    }

}
