package com.leet.code.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 143, 链表重排
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 采用双端队列
     * @param head
     */
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head.next;
        while (cur != null) {
            deque.offer(cur);
            cur = cur.next;
        }
        cur = head;
        int count = 0;
        while (!deque.isEmpty()) {
            if (count % 2 == 0) {
                cur.next = deque.pollLast();

            } else {
                cur.next = deque.poll();
            }
            cur = cur.next;
            count++;
        }
        cur.next = null;
    }
}
