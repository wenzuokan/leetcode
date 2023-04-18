package com.leet.code.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 93,复原IP地址
 */
public class RestoreIpAddresses {

    List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(s,0,0);
        return res;
    }

    void backtracking(String s,int index,int point){
        if (point==3){
            if (isValid(s,index,s.length()-1)){
                res.add(s);
            }
            return;
        }
        for (int i=index;i<s.length();i++){
            if (isValid(s,index,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                point++;
                backtracking(s,i+1,point);
                point--;
                s=s.substring(0,i+1)+s.substring(i+2);
            }else {
                break;
            }
        }
    }

    boolean isValid(String s,int start,int end){
        if (start>end){
            return false;
        }
        if (s.charAt(start)=='0'&&start!=end){
            return false;
        }
        int sum=0;
        for (int i = start; i <=end; i++) {
            if (s.charAt(i)>'9'||s.charAt(i)<'0'){
                return false;
            }
            sum=sum*10+(s.charAt(i)-'0');
            if (sum>225){
                return false;
            }
        }
        return true;
    }
}
