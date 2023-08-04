package cn.yy.leetcode.solutions.day04;

/*
给出一个完全二叉树，求出该树的节点个数。
 */


import java.util.ArrayDeque;

public class Solution39 {

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            count += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}



