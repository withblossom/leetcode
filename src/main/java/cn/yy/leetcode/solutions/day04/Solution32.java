package cn.yy.leetcode.solutions.day04;

/*
给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution32 {


    public static List<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int r = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (node.val > r){
                    r = node.val;
                }
                if (node.left !=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
            }
            list.add(r);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;
}


