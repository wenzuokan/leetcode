package com.leet.code.dynamic;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode
 */
public class RobIII {

    public static class TreeNode {
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

    public int rob(TreeNode root) {
        int[] dp=robAction(root);
        return Math.max(dp[0],dp[1]);
    }
    int[] robAction(TreeNode root){
        int[] dp=new int[2];
        if (root==null){
            return dp;
        }
        int[] left=robAction(root.left);
        int[] right=robAction(root.right);

        // 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
        dp[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
        dp[1]=root.val+left[0]+right[0];
        return dp;
    }
}
