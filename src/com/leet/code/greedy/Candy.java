package com.leet.code.greedy;

import java.util.Arrays;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 135,分发糖果
 */
public class Candy {

    /**
     * 先确定右边评分大于左边的情况（也就是从前向后遍历）
     * 此时局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
     * 局部最优可以推出全局最优。
     * 如果ratings[i] > ratings[i - 1] 那么[i]的糖 一定要比[i - 1]的糖多一个，所以贪心：candyVec[i] = candyVec[i - 1] + 1
     *
     * 再确定左孩子大于右孩子的情况（从后向前遍历）
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candyVec=new int[ratings.length];
        candyVec[0]=1;
        for (int i=1;i<ratings.length;i++){
            candyVec[i]=(ratings[i]>ratings[i-1])?candyVec[i-1]+1:1;
        }
        for (int i=ratings.length-2;i>=0;i--){
            candyVec[i]=Math.max(candyVec[i],candyVec[i+1]+1);
        }
        return Arrays.stream(candyVec).sum();
    }
}
