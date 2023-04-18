package com.leet.code.linkedlist;


/**
 * @author Drew
 * @create 2023-03
 * @LeetCode
 */
public class SwapPairs {

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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next;
            cur.next = temp2;
            temp1.next = temp2.next;
            temp2.next = temp1;
            cur = temp1;
        }
        return dummy.next;
    }
}
