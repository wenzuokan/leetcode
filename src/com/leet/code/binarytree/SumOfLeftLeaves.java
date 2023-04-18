package com.leet.code.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 404,左叶子之和
 */
public class SumOfLeftLeaves {

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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count=0;
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if (cur.left!=null&&cur.left.left==null&&cur.left.right==null){
                count+=cur.left.val;
            }
            if (cur.right!=null){
                queue.offer(cur.right);
            }
            if (cur.left!=null){
                queue.offer(cur.left);
            }
        }
        return count;
    }
}
