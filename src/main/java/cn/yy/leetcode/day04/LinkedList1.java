package cn.yy.leetcode.day04;

import java.util.Arrays;
import cn.yy.leetcode.day04.LinkedNode.*;

public class LinkedList1 {


    public static void main(String[] args) {
//        LinkedNode linkedNode = new LinkedNode();
//        linkedNode.addTailNum(1);
//        linkedNode.addTailNum(2);
//        linkedNode.addTailNum(3);
//        linkedNode.addTailNum(4);
//        linkedNode.addTailNum(5);
//        LinkedNode.show(linkedNode.head);
////        System.out.println(linkedNode.getNode(2));
//
//        linkedNode.addNode(2,new Node(10));
//
//        linkedNode.show();
//
//        linkedNode.removeNode(2);
//
//        linkedNode.show();
//
//        linkedNode.removeLastNode(2);
//
//        linkedNode.show();
//
//        linkedNode.removeLastNodeNew(2);
//
//        linkedNode.show();
//        linkedNode.reverse();
//
//        linkedNode.show();

//        LinkedNode.reverse(linkedNode);
//        linkedNode.reverse();
//
//        LinkedNode.show(linkedNode.head);

        LinkedNode linkedNode = new LinkedNode();
        LinkedNode linkedNode1 = new LinkedNode();
        linkedNode.addTailNum(1);
        linkedNode.addTailNum(2);
        linkedNode1.addTailNum(11);
        linkedNode1.addTailNum(22);
        Node node = new Node(111);
        Node node1 = new Node(222);
        linkedNode.addTail(node1);
//        linkedNode.addTail(node);
        linkedNode1.addTail(node1);
        linkedNode1.addTail(node);
        linkedNode.show();
        linkedNode1.show();

        Node cross = LinkedNode.findCross(linkedNode1, linkedNode);
        System.out.println(cross);

    }
}



