package com.leet.code.linkedlist;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 234,回文链表
 */
public class IsPalindrome {

    public class ListNode {
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

    //链表注入数组进行判断
    public boolean isPalindrome(ListNode head) {
        int[] res = transfer(head);
        for (int i = 0, j = res.length - 1; i < j; i++, j--) {
            if (res[i] != res[j]) {
                return false;
            }
        }
        return true;
    }
    public static int[] transfer(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }

    //分割链表，反转链表后进行比较
    public boolean isPalindromeII(ListNode head) {
        return true;
    }
}
