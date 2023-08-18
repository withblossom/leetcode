package cn.yy.leetcode.solutions.day03;

/*
给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。
与实际答案相差 10-5 以内的答案可以被接受。
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution30 {


    //层序遍历
    public static List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0;
            // 一层
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                //求和
                sum += node.val;
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            //一层遍历完成, sum 除以这层的节点数 得平均数
            list.add(sum * 1.0 / size );
        }
        return list;
    }

    public static void main(String[] args) {

    }
}

