package com.leet.code.binarytree;

import java.sql.Statement;
import java.util.*;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 199, 二叉树的右视图
 */
public class RightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Stack<TreeNode> stack = new Stack<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode cur = queue.poll();
                stack.push(cur);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                len--;
            }
            result.add(stack.pop().val);
        }
        return result;
    }
}
