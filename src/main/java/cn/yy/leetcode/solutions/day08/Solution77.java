package cn.yy.leetcode.solutions.day08;

/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */


public class Solution77 {

    public  static TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0){
            return null;
        }
        return sortedArrayToBST(nums,0, nums.length);
    }

    public  static TreeNode sortedArrayToBST(int[] nums,int left,int right) {
        if (left>=right){
            return null;
        }
        if (left+1==right){
            TreeNode node = new TreeNode();
            node.val=nums[left];
            return node;
        }
        int mid = left + ((right-left)>>1);
        TreeNode node = new TreeNode();
        node.val=nums[mid];
        node.left =  sortedArrayToBST(nums,left,mid);
        node.right =  sortedArrayToBST(nums,mid+1,right);
        return node;
    }
    public static void main(String[] args) {
//        sortedArrayToBST(new int[]{-10,-3,0,5,9});
//        System.out.println((2-2)>>1);
    }
}

