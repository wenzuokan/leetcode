package com.leet.code.binarytree;

import java.util.Stack;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode
 */
public class GetMinimumDifference {

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
    public int getMinimumDifference(TreeNode root) {
        if (root==null){
            return 0;
        }
        TreeNode pre=null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        int res=Integer.MAX_VALUE;
        while (!stack.isEmpty()||cur!=null){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                cur=stack.pop();
                if (pre!=null){
                    res=Math.min(res,cur.val-pre.val);
                }
                pre=cur;
                cur=cur.right;
            }
        }
        return res;
    }
}
