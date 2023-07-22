package cn.yy.leetcode.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTree {
    Node head;

    public BinaryTree() {
    }

    public BinaryTree(int val) {
        head = new Node(val);
    }


    public static Node lowestCommonAncestor(Node node,Node q,Node p){
        if (node==null||node==q||node==p){
            return node;
        }
        Node left = lowestCommonAncestor(node.left, q, p);
        Node right = lowestCommonAncestor(node.right, q, p);
        if (left==null&&right==null){
            return null;
        }else if (left!=null&&right!=null){
            return node;
        }else if (left!=null){
            return left;
        }else {
            return right;
        }
    }

    public static Node lowestCommonAncestorBST(Node node,Node q,Node p){
        if (node==null){
            return null;
        }
        if (node.val< p.val&&node.val< q.val){
            return lowestCommonAncestorBST(node.right,q,p);
        }
        if (node.val> q.val&&node.val> p.val){
            return lowestCommonAncestorBST(node.left,q,p);
        }
        return node;
    }

    public static Node lowestCommonAncestorBST1(Node node,Node q,Node p){
        while (true){
            if (node.val< p.val&&node.val< q.val){
                node=node.right;
            }else if (node.val> q.val&&node.val> p.val){
                node=node.left;
            }else {
                return node;
            }
        }
    }

    public static Node insertIntoBST(Node node,int val){
        if (node==null){
            return new Node(val);
        }
        if (node.val>val){
            node.left = insertIntoBST(node.left,val);
        }
        if (node.val<val){
            node.right = insertIntoBST(node.right,val);
        }
        return node;
    }

    public static Node insertIntoBST1(Node node,int val){
        if (node==null){
            return new Node(val);
        }
        Node pre =null;
        while (node!=null){
            pre = node;
            if (node.val>val){
                node=node.left;
            }else if (node.val<val){
                node=node.right;
            }
        }
        if (pre.val>val){
            pre.left = new Node(val);
        }
        if (pre.val<val){
            pre.right = new Node(val);
        }
        return node;
    }

    public static Node deleteNode(Node node,int val){
        if (node==null){
            return null;
        }
        if (node.val==val){
            if (node.right==null){
                return node.left;
            }
            Node pre = node.right;
            while (pre.left!=null){
                pre=pre.left;
            }
            pre.left = node.left;
            return node.right;
        }
        if (node.val>val){
            node.left = deleteNode(node.left,val);
        }else {
            node.right = deleteNode(node.right,val);
        }
        return node;
    }

    public static Node trimBST(Node node,int l,int r){
        if (node==null){
            return null;
        }
        if (node.val>=l&&node.val<=r){
            node.left=trimBST(node.left, l,r);
            node.right=trimBST(node.right, l,r);
        }else {
            if (node.val>r){
                return trimBST(node.left,l,r);
            }
            return trimBST(node.right,l,r);
        }
        return node;
    }

    public static Node sortedArrayToBST(int[] nums){
        if (nums==null||nums.length==0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length);
    }

    public static Node sortedArrayToBST(int[] nums,int l,int r){
        if (l>=r){
            return null;
        }
        int mid = l+ (r - l) / 2;
        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums,l,mid);
        node.right = sortedArrayToBST(nums,mid+1,r);
        return node;
    }

    public static void preOrder(Node node){
        if (node == null) {
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    static int sum;

    public static void convertBST(Node node){
        if (node==null){
            return;
        }
        convertBST(node.right);
        sum+=node.val;
        node.val=sum;
        convertBST(node.left);
    }
    /*
        0
      1  2
     3  6 4
    5
     */
    public static void main(String[] args) {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.left = node5;
        node2.left = node6;

        Node root = deleteNode(node, 0);
        preOrder(root);


    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
