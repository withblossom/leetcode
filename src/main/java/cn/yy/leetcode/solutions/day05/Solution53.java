package cn.yy.leetcode.solutions.day05;

/*
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */


public class Solution53 {

    public TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return Integer.MAX_VALUE;
        }
        int min = getMinimumDifference(root.left);
        if (pre != null){
            min = Math.min(min,root.val - pre.val);
        }
        pre = root;
        return Math.min(min,getMinimumDifference(root.right));
    }

    public static void main(String[] args) {

    }
}



