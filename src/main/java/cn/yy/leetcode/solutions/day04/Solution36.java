package cn.yy.leetcode.solutions.day04;

/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。
 */


public class Solution36 {

    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null){
            return minDepth(root.right) + 1;
        }
        if (root.right == null){
            return minDepth(root.left) + 1;
        }
        return Math.max(minDepth(root.left),minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}



