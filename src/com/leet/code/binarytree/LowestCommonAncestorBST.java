package com.leet.code.binarytree;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 235, 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        } else if (root.val < q.val && root.val < p.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return root;
    }

    //迭代法
    public TreeNode iteration(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if (root.val>p.val&&root.val> q.val){
                root=root.left;
            }else if (root.val< q.val&&root.val< p.val){
                root=root.right;
            }else break;
        }
        return root;
    }
}
