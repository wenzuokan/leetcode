package com.leet.code.linkedlist;

/**
 * @author Drew
 * @create 2023-03
 * @LeetCode 142,环形链表II
 */
public class DetectCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 1,判断链表是否有环
     * 可以使用快慢指针法，分别定义 fast 和 slow 指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，
     * 如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。
     * 2,如果有环，找入口
     * 从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点。
     * 也就是在相遇节点处，定义一个指针index1，在头结点处定一个指针index2。
     * 让index1和index2同时移动，每次移动一个节点， 那么他们相遇的地方就是 环形入口的节点。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
