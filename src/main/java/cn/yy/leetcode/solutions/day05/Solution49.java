package cn.yy.leetcode.solutions.day05;

/*
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */


public class Solution49 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start >= end){
            return null;
        }
        if (start + 1 == end) {
            return new TreeNode(nums[start + 1]);
        }
        int index = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTree(nums, start, index);
        node.right = constructMaximumBinaryTree(nums, index + 1, end);
        return node;
    }

    public static void main(String[] args) {

    }
}



