package com.leet.code.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 116, 填充每个节点的下一个右侧指针
 */
public class Connect {

    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();

            Node cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            for (int i = 1; i < len; i++) {
                Node next=queue.poll();
                if (next.left!=null){
                    queue.offer(next.left);
                }
                if (next.right!=null){
                    queue.offer(next.right);
                }
                cur.next=next;
                cur=next;
            }

        }
        return root;
    }
}
