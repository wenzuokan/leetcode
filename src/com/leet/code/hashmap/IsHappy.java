package com.leet.code.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 202,快乐数
 */
public class IsHappy {

    public boolean idHappy(int n){
        Set<Integer> record=new HashSet<>();
        while (n!=0&&!record.contains(n)){
            record.add(n);
            n=getNum(n);
        }
        return n==1;
    }

    //做数位分离，求平方和
    private int getNum(int n){
        int sum=0;
        while (n>0){
            int d=n%10;
            n=n/10;
            sum+=d*d;
        }
        return sum;
    }
}
