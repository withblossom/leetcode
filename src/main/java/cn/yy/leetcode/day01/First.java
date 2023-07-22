package cn.yy.leetcode.day01;

public class First {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(9);
        node1.next = node2;
        node3.next = node4;
        node1.list();
        node3.list();
        ListNode listNode = addTwoNumbers1(node1, node3);
        listNode.list();
//        node1.setChild(node2);
//        node2.setChild(node3);
//        node4.setChild(node5);
//        node5.setChild(node6);
//        node6.setChild(node7);
//        ListNode add = addTwoNumbers(node1, node4);
//        node1.list();
//        node4.list();
//        add.list();
    }


    public static ListNode addTwoNumbers(ListNode node1,ListNode node2){
        ListNode node = null;
        if (node1 == null && node2 == null){
            return node;
        }
        if (node1 == null || node2 == null){
            ListNode current = (node1 == null ? node2 : node1);
            node = new ListNode(current.val);
            ListNode now = node;
            while (current.next != null){
                current = current.next;
                now.next = new ListNode(current.val);
                now = now.next;
            }
            return node;
        }
        ListNode c1 = node1;
        ListNode c2 = node2;
        int res = (c1.val + c2.val) % 10, sur = (c1.val + c2.val) / 10;
        node = new ListNode(res);
        ListNode c = node;
        while (true){
            res = sur;
            if (c1.next != null){
                c1 = c1.next;
                res += c1.val;
            }
            if (c2.next != null){
                c2 = c2.next;
                res += c2.val;
            }
            sur = res / 10;
            res = res % 10;
            c.next = new ListNode(res);
            c = c.next;
            if (c1.next == null && c2.next == null){
                if (sur != 0){
                    c.next = new ListNode(sur);
                }
                break;
            }
        }
        return node;
    }
    public static ListNode addTwoNumbers1(ListNode node1,ListNode node2){
        ListNode node = new ListNode(0);
        ListNode cur = node;
        int sur = 0, sum;
        while (true){
            sum = sur;
            if (node1 == null && node2 == null){
                if (sum != 0){
                    cur.next = new ListNode(sum);
                }
                break;
            }
            if (node1 != null){
                sum += node1.val;
                node1 = node1.next;
            }
            if (node2 != null){
                sum += node2.val;
                node2 = node2.next;
            }
            sur = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        return node.next;
    }
}

class ListNode {
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
    public void list(){
        ListNode cur = this;
        System.out.print(cur.val);
        while (cur.next != null){
            cur = cur.next;
            System.out.print("->" + cur.val);
        }
        System.out.println();
    }
}
//
//class ListNode{
//    private int value;
//    private ListNode child;
//
//    public ListNode(int value) {
//        this.value = value;
//    }
//
//    public int getValue() {
//        return value;
//    }
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    public void setChild(ListNode child) {
//        this.child = child;
//    }
//    public ListNode getChild() {
//        return child;
//    }
//    public void list(){
//        ListNode current = child;
//        System.out.print(value);
//        while (current.getChild() != null){
//            current = current.getChild();
//            System.out.print("->" + current.value);
//        }
//        System.out.println();
//    }
//}