package com.leet.code.linkedlist;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 19,删除链表的倒数第N个结点
 */
public class RemoveNthFromEnd {

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
     * 双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，
     * 直到fast指向链表末尾。删掉slow所指向的节点就可以了。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy=new ListNode(0);
         dummy.next=head;
         ListNode fast=dummy;
         ListNode slow=dummy;
         for (int i=0;i<n;i++){
             fast=fast.next;
         }
         while (fast.next!=null){
             fast=fast.next;
             slow=slow.next;
         }
         slow.next=slow.next.next;

         return dummy.next;
    }
}
