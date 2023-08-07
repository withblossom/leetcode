package cn.yy.leetcode.solutions.day05;

/*
给定两个整数数组 inorder 和 postorder ，
其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */


import java.util.*;
import java.util.stream.Stream;

public class Solution47 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i );
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length,map);
    }

    public static TreeNode buildTree(int[] inorder, int startI, int endI, int[] postorder, int startP, int endP,HashMap<Integer,Integer> map) {
        if (endP < startP + 1) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[endP - 1]);
        int index = map.get(postorder[endP - 1]);
        int len = index - startI;
        node.left = buildTree(inorder, startI, index, postorder, startP, startP + len,map);
        node.right = buildTree(inorder, index + 1, endI, postorder, startP + len, endP - 1,map);
        return node;
    }

    public static void main(String[] args) {

    }
}



