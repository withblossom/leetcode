package cn.yy.leetcode.day05;

import cn.yy.leetcode.day04.LinkedNode;

/*
    给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Array3 {
    public static void main(String[] args) {

    }

    public static LinkedNode.Node findCircle(LinkedNode linkedNode1,LinkedNode linkedNode2){
        if (linkedNode1.size()==0||linkedNode2.size()==0) {
            return null;
        }
        LinkedNode.Node head1 = linkedNode1.getNode(0);
        LinkedNode.Node head2 = linkedNode2.getNode(0);
        LinkedNode.Node head=head1;
        while (head1!=null&&head1.next!=null){
            head1=head1.next.next;
            head2=head2.next;
            if (head1==head2){
                while (head1!=head){
                    head1=head1.next;
                    head=head.next;
                }
                return head;
            }
        }
        return null;
    }
}

