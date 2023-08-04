package cn.yy.leetcode.review;

public class LinkedList2 {

    /*
    题意：反转一个单链表。

示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
     */
    public static ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseList1(ListNode node) {
        ListNode head = new ListNode();
        while (node != null) {
            ListNode cur = node;
            node = node.next;
            cur.next = head.next;
            head.next = cur;
        }
        return head.next;
    }

    public static ListNode reverseList2(ListNode node) {
        return reverseList2(null, node);
    }

    public static ListNode reverseList2(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverseList2(cur, next);
    }
}

