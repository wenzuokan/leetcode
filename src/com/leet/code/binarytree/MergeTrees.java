package com.leet.code.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 617, 合并二叉树
 */
public class MergeTrees {

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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public TreeNode iteration(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()){
            TreeNode node1=queue.poll();
            TreeNode node2=queue.poll();
            node1.val+=node2.val;
            if (node1.left!=null&&node2.left!=null){
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            if (node1.right!=null&&node2.right!=null){
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            if (node1.left==null&&node2.left!=null){
                node1.left=node2.left;
            }
            if (node1.right==null&&node2.right!=null){
                node1.right=node2.right;
            }
        }
        return root1;
    }
}
