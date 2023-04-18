package com.leet.code.binarytree;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 106, 从中序与后序遍历序列构造二叉树
 * 105,从中序与前序遍历序列构造二叉树
 */
public class BuildTree {

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

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);// 前闭后开
    }

    public TreeNode findNode(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart >= inEnd || postStart >= postEnd) {
            return null;
        }
        int rootVal = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootVal]);
        int lenLeft = rootVal - inStart;
        root.left = findNode(inorder, inStart, rootVal, postorder, postStart, postStart + lenLeft);
        root.right = findNode(inorder, rootVal + 1, inEnd, postorder, postStart + lenLeft, postEnd - 1);
        return root;
    }


    public TreeNode buildTreePI(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findRoot(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode findRoot(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart >= pEnd || iStart >= iEnd) {
            return null;
        }
        int inorderStart = map.get(preorder[pStart]);
        TreeNode root = new TreeNode(inorder[inorderStart]);
        int len = inorderStart - iStart;
        root.left = findRoot(preorder, pStart + 1, pStart + len + 1, inorder, iStart, inorderStart);
        root.right = findRoot(preorder, pStart + len + 1, pEnd, inorder, inorderStart + 1, iEnd);
        return root;
    }
}
