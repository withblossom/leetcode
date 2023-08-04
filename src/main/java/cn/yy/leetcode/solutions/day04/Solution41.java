package cn.yy.leetcode.solutions.day04;

/*
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。
 */


import java.util.ArrayList;
import java.util.List;

public class Solution41 {

    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        binaryTreePaths(root, root.val+"", list);
        return list;
    }

    public static void binaryTreePaths(TreeNode root, String str, ArrayList<String> list) {
        if (root.left == null && root.right == null) {
            list.add(str);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, str+"->"+root.left.val, list);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, str+"->"+root.right.val, list);
        }
    }

    public static void main(String[] args) {

    }
}



