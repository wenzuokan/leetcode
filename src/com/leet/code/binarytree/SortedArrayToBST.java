package com.leet.code.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 108,将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedToBST(nums,0,nums.length);
    }
    public TreeNode sortedToBST(int[] nums,int left,int right){
        if (left>=right){
            return null;
        }
        if (right-left==1){
            return new TreeNode(nums[left]);
        }
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedToBST(nums,left,mid);
        root.right=sortedToBST(nums,mid+1,right);
        return root;
    }

    public TreeNode iteration(int[] nums) {
       if (nums.length==0){
           return null;
       }
       TreeNode root=new TreeNode(-1);
        Queue<TreeNode> node=new LinkedList<>();
        Queue<Integer> leftQueue=new LinkedList<>();
        Queue<Integer> rightQueue=new LinkedList<>();
        node.offer(root);
        leftQueue.offer(0);
        rightQueue.offer(nums.length-1);
        while (!node.isEmpty()){
            TreeNode cur=node.poll();
            int left=leftQueue.poll();
            int right=rightQueue.poll();
            int mid=left+(right-left)>>1;
            cur.val=nums[mid];

            if (left<=mid-1){
                cur.left=new TreeNode(-1);
                node.offer(cur.left);
                leftQueue.offer(left);
                rightQueue.offer(mid-1);
            }
            if (right>=mid+1){
                cur.right=new TreeNode(-1);
                node.offer(cur.right);
                leftQueue.offer(mid+1);
                rightQueue.offer(right);
            }
        }
        return root;
    }
}
