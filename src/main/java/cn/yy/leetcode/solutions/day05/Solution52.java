package cn.yy.leetcode.solutions.day05;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */


public class Solution52 {

    public TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public static void main(String[] args) {

    }
}



