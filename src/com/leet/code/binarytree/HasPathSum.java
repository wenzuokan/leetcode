package com.leet.code.binarytree;

import java.util.Stack;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 112, 路径总和
 */
public class HasPathSum {

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

    //递归法
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    //迭代法
    public boolean iteration(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        Stack<TreeNode> node=new Stack<>();
        Stack<Integer> val=new Stack<>();
        node.push(root);
        val.push(root.val);
        while (!node.isEmpty()){
            int len=node.size();
            for (int i = 0; i < len; i++) {
                int sum=val.pop();
                TreeNode cur=node.pop();
                if (cur.left==null&&cur.right==null&&sum==targetSum){
                    return true;
                }
                if (cur.left!=null){
                    node.push(cur.left);
                    val.push(sum+cur.left.val);
                }
                if (cur.right!=null){
                    node.push(cur.right);
                    val.push(sum+cur.right.val);
                }
            }
        }
        return false;
    }
}
