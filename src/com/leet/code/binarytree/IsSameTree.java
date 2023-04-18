package com.leet.code.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 100,相同的树
 */
public class IsSameTree {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            TreeNode one=queue.poll();
            TreeNode two=queue.poll();
            if (one==null&&two==null){
                continue;
            }
            if (one==null||two==null||one.val!=two.val){
                return false;
            }
            queue.offer(one.left);
            queue.offer(two.left);
            queue.offer(one.right);
            queue.offer(two.right);
        }
        return true;
    }
}
