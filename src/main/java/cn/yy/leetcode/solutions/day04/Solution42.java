package cn.yy.leetcode.solutions.day04;

/*
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */


public class Solution42 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q==null){
            return true;
        }else if (q == null || p == null){
            return false;
        }else if (p.val !=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {

    }
}



