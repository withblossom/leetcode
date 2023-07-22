package cn.yy.leetcode.day04;


public class LinkedNode{
    Node head = new Node(-1);
    int size;

    public void show(){
        Node cur = head;
        System.out.print(head.value);
        while (cur.next!=null){
            cur=cur.next;
            System.out.print(" ==>> "+cur.value);
        }
        System.out.println();
    }
    public static void show(Node head){
        Node cur = head;
        System.out.print(head.value);
        while (cur.next!=null){
            cur=cur.next;
            System.out.print(" ==>> "+cur.value);
        }
        System.out.println();
    }
    public void addHeadNum(int value){
        addHead(new Node(value));
    }
    public void addTailNum(int value){
        addTail(new Node(value));
    }
    public void addHead(Node node){
        node.next=head.next;
        head.next=node;
        size++;
    }
    public void addTail(Node node){
        Node cur = head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        size++;
    }
    public void addNodeNum(int index,int value){
        addNode(index, new Node(value));
    }
    public void addNode(int index,Node node){
        size++;
        if (index<0){
            addHead(node);
        }else if (index>=size){
            addTail(node);
        }else {
            Node cur = head,next=head.next;
            for (int i=0;i<index;i++){
                cur= cur.next;
                next=next.next;
            }
            node.next=cur.next;
            cur.next=node;
        }
    }
    public int size(){
        return size;
    }
    public Node getNode(int index){
        if (index<0 || index>size-1){
            return null;
        }
        Node cur=head.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }
    public void removeNode(int index){
        if (index<0&&index>size-1){
            return;
        }
        Node pre=head;
        for (int i=0;i<index;i++){
            pre=pre.next;
        }
        pre.next=pre.next.next;
        size--;
    }
    public void removeLastNode(int lastNum){
        removeNode(size-lastNum);
    }
    public void removeLastNodeNew(int lastNum){
        if (lastNum<1&&lastNum>size){
            return;
        }
        Node pre=head,gapNext=head;
        for (int i=0;i<lastNum;i++){
            gapNext=gapNext.next;
        }
        while (gapNext.next!=null){
            pre=pre.next;
            gapNext=gapNext.next;
        }
        pre.next=gapNext;
        size--;
    }
    public void reverse(){
        Node newRoot = new Node(-1);
        Node cur;
        while (head.next!=null){
            cur= head.next;
            head.next= head.next.next;
            cur.next=newRoot.next;
            newRoot.next=cur;
        }
        head=newRoot;
    }
    public static Node reverse(Node head){
        Node newRoot = new Node(-1);
        Node cur;
        while (head.next!=null){
            cur= head.next;
            head.next= head.next.next;
            cur.next=newRoot.next;
            newRoot.next=cur;
        }
        return newRoot;
    }
    public static void reverse(LinkedNode linkedNode){
        linkedNode.head= LinkedNode.reverse(linkedNode.head);
    }
    public static Node findCross(LinkedNode linkedNode1,LinkedNode linkedNode2){
        int size1 = linkedNode1.size;
        int size2 = linkedNode2.size;
        if (size1==0||size2==0){
            return null;
        }
        Node node1= linkedNode1.head;
        Node node2= linkedNode2.head;
        if (size2>size1){
            int tmp=size1;
            size1=size2;
            size2=tmp;
            Node temp=node1;
            node1=node2;
            node2=temp;
        }
        for (int i=0;i<size2-size1;i++){
            node1=node1.next;
        }
        while (node1.next!=node2.next){
            if (node1.next==null){
                return null;
            }
            node1=node1.next;
            node2=node2.next;
        }
        return node1.next;
    }

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +"value=" + value +'}';
        }
    }
}
