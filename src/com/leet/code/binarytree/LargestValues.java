package com.leet.code.binarytree;


import java.util.*;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 515,在每个树行中找最大值
 */
public class LargestValues {

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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            int large=Integer.MIN_VALUE;
            while (len>0){
                TreeNode cur=queue.poll();
                large=Math.max(large,cur.val);
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
                len--;
            }
            res.add(large);
        }
        return res;
    }
}
