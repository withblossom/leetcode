package cn.yy.leetcode.solutions.day03;

/*
给定一个二叉树的根root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution29 {


    //这题用到层序遍历
    //只不过不是取每层的所有节点，而是取每层最后一个节点的值
    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            // 一层
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                //最后一个节点
                if (i == size - 1){
                    list.add(node.val);
                }
                if (node.left != null){
                    deque.addLast(node.left);
                }
                if (node.right != null){
                    deque.addLast(node.right);
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {

    }
}

