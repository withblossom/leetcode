package cn.yy.leetcode.day13;

import cn.yy.leetcode.day04.LinkedNode;

public class Solution9 {

    /*
给定一个二叉树，我们在树的节点上安装摄像头。

节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

计算监控树的所有节点所需的最小摄像头数量。
     */
    //摄像头个数
    static int result;

    public static int traversal(Node node) {
        //返回 0 ；表示未覆盖， 1 ：该处为摄像头， 2：已覆盖
        if (node == null) {
            return 2;
        }
        int left = traversal(node.left);
        int right = traversal(node.right);
        //左右子节点都已覆盖，该节点标记为未覆盖返回 0
        if (left == 2 && right == 2) {
            return 0;
        //左右节点有一个未覆盖，则该节点加摄像头
        } else if (left == 0 || right == 0) {
            result++;
            return 1;
        } else {
            return 2;
        }
    }
    public static int minCameraCover(Node root) {
        if (traversal(root) == 0){
            result++;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}

class Node {
    int val;
    Node left;
    Node right;
}
