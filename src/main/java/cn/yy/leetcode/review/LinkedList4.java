package cn.yy.leetcode.review;

public class LinkedList4 {

    /*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？
     */
    public static ListNode removeNthFromEnd(ListNode node, int n) {
        if (node == null) {
            return node;
        }
        ListNode head = new ListNode();
        head.next = node;
        ListNode fast = head;
        ListNode slow = head;
        while (n-- > 0) {
            fast = fast.next;
            if (fast == null) {
                return node;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head.next;
    }

}

