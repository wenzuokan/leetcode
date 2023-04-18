package com.leet.code.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 501,二叉搜索树中的众数
 */
public class FindMode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int[] findMode(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        TreeNode pre=null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        int count=0;
        int max=0;
        while (!stack.isEmpty()||cur!=null){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                cur=stack.pop();
                if (pre!=null&&cur.val!= pre.val){
                    count=1;
                }else {
                    count++;
                }
                //更新结果
                if (count>max){
                    max=count;
                    res.clear();
                    res.add(cur.val);
                }else if (count==max){
                    res.add(cur.val);
                }
                pre=cur;
                cur=cur.right;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
