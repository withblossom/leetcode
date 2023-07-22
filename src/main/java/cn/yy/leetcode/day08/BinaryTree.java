package cn.yy.leetcode.day08;

import java.util.LinkedList;

public class BinaryTree {
    Node head;

    public BinaryTree() {
    }

    public BinaryTree(int val) {
        head = new Node(val);
    }

    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void midOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        midOrderTraversal(root.left);
        System.out.println(root);
        midOrderTraversal(root.right);
    }

    public static void sufOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        sufOrderTraversal(root.left);
        sufOrderTraversal(root.right);
        System.out.println(root);
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.addLast(root);
        while (!nodes.isEmpty()) {
            for (int i = 0; i < nodes.size(); i++) {
                Node node = nodes.removeFirst();
                System.out.println(node);
                if (node.left != null) nodes.addLast(node.left);
                if (node.right != null) nodes.addLast(node.right);
            }
        }
    }

    public static void preOrderTraversal1(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.addLast(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            System.out.println(node);
            if (node.right != null) nodes.push(node.right);
            if (node.left != null) nodes.push(node.left);
        }
    }

    public static void sufOrderTraversal1(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.addLast(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            System.out.println(node);
            if (node.left != null) nodes.push(node.left);
            if (node.right != null) nodes.push(node.right);
        }
        // TODO: 2023/7/17 翻转结果
    }

    public static void midOrderTraversal1(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> nodes = new LinkedList<>();
        Node cur = root;
        while (cur != null || !nodes.isEmpty()) {
            if (cur != null) {
                nodes.push(cur);
                cur = cur.left;
            } else {
                Node node = nodes.pop();
                System.out.println(node);
                cur = node.right;
            }
        }
    }

    public static void invertTree(Node root) {
        if (root == null) {
            return;
        }
        invertTree(root.left);
        invertTree(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static boolean isSymmetric(Node node){
        if (node==null){
            return true;
        }
        return isSymmetric(node.left, node.right);
    }

    public static boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) &&
                isSymmetric(left.right, right.left);
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int right = minDepth(root.right);
        int left = minDepth(root.left);
        if (root.left == null) {
            return right + 1;
        }
        if (root.right == null) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int isBalanced(Node root) {
        if (root == null) {
            return 0;
        }
        int left = isBalanced(root.left);
        if (left == -1) {
            return -1;
        }
        int right = isBalanced(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    /*
        0                     1
      1  2                 3     3
     3    4               3 4   5 4
    5                    4 5       6
   6                    7
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
        node5.left = node6;
//        preOrderTraversal(node);
//        midOrderTraversal(node);
//        sufOrderTraversal(node);

//        preOrderTraversal1(node);
//        midOrderTraversal1(node);
//        sufOrderTraversal1(node);

//        invertTree(node);

//        preOrderTraversal(node);

//        System.out.println(maxDepth(node,0));
//        System.out.println(minDepth(node, 0));
        System.out.println(countNodes(node));
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
