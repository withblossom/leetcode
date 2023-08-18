package cn.yy.leetcode.solutions.day04;

/*
给定一个二叉树，检查它是否是镜像对称的。
 */


public class Solution38 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right==null){
            return true;
        }else if (left == null || right == null){
            return false;
        }else if (left.val != right.val){
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
    public static void main(String[] args) {

    }
}



