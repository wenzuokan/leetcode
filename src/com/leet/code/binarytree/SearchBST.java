package com.leet.code.binarytree;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 700,二叉搜索树中的搜索
 */
public class SearchBST {

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

    public TreeNode iteration(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        while (root!=null){
            if (root.val<val){
                root=root.right;
            }else if (root.val>val){
                root=root.left;
            }else {
                return root;
            }
        }
        return null;
    }

    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null||root.val==val){
            return root;
        }
        if (root.val>val){
            return searchBST(root.left,val);
        }else {
            return searchBST(root.right,val);
        }
    }
}
