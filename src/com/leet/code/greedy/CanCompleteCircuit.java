package com.leet.code.greedy;


/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 134,加油站
 */
public class CanCompleteCircuit {

    /**
     * 情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
     * 情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，
     *        说明从0出发，油就没有断过，那么0就是起点。
     * 情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平，能把这个负数填平的节点就是出发节点
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int min=0;
        for (int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            min=Math.min(min,sum);
        }
        if (sum<0){
            return -1;
        }
        if (min>=0){
            return 0;
        }
        for (int i = 0; i < gas.length; i++) {
            min+=gas[i]-cost[i];
            if (min>=0){
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuitII(int[] gas, int[] cost) {
        int cur=0;
        int sum=0;
        int index=0;
        for (int i = 0; i < gas.length; i++) {
            cur+=gas[i]-cost[i];
            sum+=gas[i]-cost[i];
            if (cur<0){
                index=(i+1)%gas.length;
                cur=0;
            }
        }
        if (sum<0){
            return -1;
        }
        return index;
    }
}
