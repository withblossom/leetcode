package cn.yy.leetcode.review;

public class LinkedList5 {

    /*
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     */
    public static ListNode getIntersectionNode(ListNode node1, ListNode node2) {
        ListNode temp = node1;
        int len1 = 0;
        while (temp != null) {
            len1++;
            temp = temp.next;
        }
        int len2 = 0;
        temp = node2;
        while (temp != null) {
            len2++;
            temp = temp.next;
        }
        if (len2 > len1) {
            int t = len1;
            len1 = len2;
            len2 = t;

            temp = node1;
            node1 = node2;
            node2 = temp;
        }
        ListNode nodeT1 = node1;
        temp = node2;
        for (int i = 0; i < len1 - len2; i++) {
            nodeT1 = nodeT1.next;
        }
        while (nodeT1 != null) {
            if (temp == nodeT1) {
                return temp;
            }
            temp = temp.next;
            nodeT1 = nodeT1.next;
        }
        return null;
    }

}

