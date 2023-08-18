package cn.yy.leetcode.solutions.day05;

/*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root==null){
            return lists;
        }
        pathSum(root,targetSum,lists, new LinkedList<>());
        return lists;
    }

    //先序遍历
    public static void pathSum(TreeNode root, int targetSum, List<List<Integer>> lists, LinkedList<Integer> list) {
        if (root==null){
            return;
        }
        //当前节点不为空，加入当前节点
        list.addLast(root.val);
        //判断当前节点是否叶子节点
        if (root.left==null&&root.right==null){
            //逻辑, 找到一条路径
            if (targetSum==root.val){
                lists.add(new LinkedList<>(list));
            }
        }
        pathSum(root.left,targetSum-root.val,lists,list);
        pathSum(root.right,targetSum-root.val,lists,list);
        // 回溯，
        list.removeLast();
    }

    public static void main(String[] args) {

    }
}
class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}



