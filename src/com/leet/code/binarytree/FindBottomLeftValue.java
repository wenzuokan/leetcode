package com.leet.code.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 513, 找树左下角的值
 */
public class FindBottomLeftValue {

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

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            Queue<TreeNode> level = new LinkedList<>();
            while (len-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                level.offer(cur);
            }
            res = level.poll().val;
        }
        return res;
    }
}
