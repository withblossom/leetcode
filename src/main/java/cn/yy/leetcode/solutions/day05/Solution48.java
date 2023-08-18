package cn.yy.leetcode.solutions.day05;

/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意: 你可以假设树中没有重复的元素。
 */


import java.util.HashMap;

public class Solution48 {

    public static TreeNode buildTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 用map保存中序序列的数值对应位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i );
        }
        return buildTree(inorder, 0, inorder.length, preorder, 0, preorder.length,map);
    }

    public static TreeNode buildTree(int[] inorder, int startI, int endI, int[] preorder, int startP, int endP,HashMap<Integer,Integer> map) {
        if (startP + 1 > endP) {
            return null;
        }
        // 构造结点
        TreeNode node = new TreeNode(preorder[startP]);
        // 找到后序遍历的最后一个元素在中序遍历中的位置
        int index = map.get(preorder[startP]);
        // 保存中序左子树个数，用来确定后序数列的个数
        int len = index - startI;
        node.left = buildTree(inorder, startI, index, preorder, startP +1, startP + len +1,map);
        node.right = buildTree(inorder, index + 1, endI, preorder, startP + len + 1, endP,map);
        return node;
    }

    public static void main(String[] args) {

    }
}



