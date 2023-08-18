package cn.yy.leetcode.solutions.day03;

/*
树层序遍历
 */


import java.util.*;

public class Solution28 {


    public static List<List<Integer>> levelOrder(TreeNode root){
        // 保存整个树的数据
        List<List<Integer>> lists = new LinkedList<>();
        // 保存一层节点
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null){
            return lists;
        }
        queue.addLast(root);
        while (!queue.isEmpty()){
            // 保存一层数据
            ArrayList<Integer> list = new ArrayList<>();
            // 该层的节点数
            int size = queue.size();
            //一个for循环遍历这一层全部节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (node.left!=null){
                    queue.addLast(node.left);
                }
                if (node.right!=null){
                    queue.addLast(node.right);
                }
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
    }
    
    public static void main(String[] args) {

    }
}

class TreeNode{
    
    int val;
    TreeNode left;
    TreeNode right;
}
