package com.leet.code.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 113,路径总和II
 */
public class PathSum {

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

    List<List<Integer>> result;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new LinkedList<>();
        path=new LinkedList<>();
        method(root,targetSum);
        return result;
    }
    private void method(TreeNode root,int count){
        if (root==null){
            return;
        }
        path.offer(root.val);
        count-=root.val;
        if (root.left==null&&root.right==null&&count==0){
            result.add(new LinkedList<>(path));
        }
        method(root.left,count);
        method(root.right,count);
        path.removeLast();
    }
}
