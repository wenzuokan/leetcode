package com.leet.code.linkedlist;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 203,移除链表元素
 */
public class RemoveElements {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
         ListNode dummy=new ListNode(0);
         dummy.next=head;
         ListNode temp=dummy;
         while(temp.next!=null){
             if (temp.next.val==val){
                 temp.next=temp.next.next;
             }else{
                 temp=temp.next;
             }
         }
         return dummy.next;
    }
}
