package cn.yy.leetcode.solutions.day11;

/*
给定一个二叉树，我们在树的节点上安装摄像头。

节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

计算监控树的所有节点所需的最小摄像头数量。
 */


public class Solution106 {

    /*
    0：该节点无覆盖
    1：本节点有摄像头
    2：本节点有覆盖
     */
    static int count = 0;

    public static int minCameraCover(TreeNode root) {
        if (minCameraCoverT(root)!=0) {
            return count;
        }
        return ++count;
    }

    public  static int minCameraCoverT(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = minCameraCoverT(root.left);
        int right = minCameraCoverT(root.right);
        if (left == 2 && right == 2) {
            return 0;
        }
        if (left == 0 || right == 0) {
            count++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        System.out.println(minCameraCover(treeNode));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

