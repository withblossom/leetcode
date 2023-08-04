package cn.yy.leetcode.solutions.day04;

/*
给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution31 {


    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.removeFirst();
                list.add(node.val);
                if (node.children!=null){
                    for (Node child : node.children) {
                        deque.addLast(child);
                    }
                }
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}
class Node{

    int val;
    List<Node> children;
}

