package com.leet.code.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 429, N叉树的层序遍历
 */
public class LevelOrderN {

    public class Node {
        int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> res = new ArrayList<>();
            while (len > 0) {
                Node cur = queue.poll();
                res.add(cur.val);
                List<Node> children = cur.children;
                if (children == null || children.size() == 0) {
                    continue;
                }
                for (Node child : children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
                len--;
            }
            list.add(res);
        }
        return list;
    }
}
