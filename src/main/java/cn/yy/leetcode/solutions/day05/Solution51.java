package cn.yy.leetcode.solutions.day05;

/*
给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */


public class Solution51 {

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        if (root.left!=null){
            TreeNode node = searchBST(root.left, val);
            if (node!=null){
                return node;
            }
        }
        if (root.right!=null){
            TreeNode node = searchBST(root.right, val);
            if (node!=null){
                return node;
            }
        }
        return null;
    }
    public static TreeNode searchBST1(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        if (root.val < val){
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {

    }
}



