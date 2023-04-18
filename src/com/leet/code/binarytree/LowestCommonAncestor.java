package com.leet.code.binarytree;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 236,二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left==null&&right==null){
            return null;
        }else if (left==null&&right!=null){
            return right;
        }else if (left!=null&&right==null){
            return left;
        }else {
            return root;
        }
    }
}
