package com.leet.code.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Drew
 * @create 2023-04
 * @LeetCode 110,平衡二叉树
 */
public class IsBalanced {
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

    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node=stack.peek();
            if (node.right==null||node.right==pre){
                if (Math.abs(getHeight(node.left)-getHeight(node.right))>1){
                    return false;
                }
                stack.pop();
                pre=node;
                root=null;// 当前结点下，没有要遍历的结点了
            }else {
                root=node.right;// 右结点还没遍历，遍历右结点
            }
        }
        return true;
    }

    int getHeight(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return 0;
        }
        int height=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            height++;
            while (len-- >0){
                TreeNode cur=queue.poll();
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }
        }
        return height;
    }

}
