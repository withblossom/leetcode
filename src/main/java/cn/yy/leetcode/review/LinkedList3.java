package cn.yy.leetcode.review;

public class LinkedList3 {

    /*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
     */
    public static ListNode swapPairs(ListNode node){
        if (node==null){
            return node;
        }
        ListNode head = new ListNode();
        head.next = node;
        ListNode cur = head;
        while (cur.next!=null && cur.next.next!=null){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = temp.next.next;
            cur.next.next = temp;
            cur = cur.next.next;
        }
        return head.next;
    }

}

