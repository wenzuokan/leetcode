package com.leet.code.binarytree;

import java.util.ArrayDeque;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 226,翻转二叉树
 */
public class InvertTree {

    public class TreeNode {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode iteration(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            int len = arrayDeque.size();
            while (len-- > 0) {
                TreeNode cur = arrayDeque.poll();
                swap(cur);
                if (cur.left != null) {
                    arrayDeque.offer(cur.left);
                }
                if (cur.right != null) {
                    arrayDeque.offer(cur.right);
                }
            }
        }
        return root;
    }
}
