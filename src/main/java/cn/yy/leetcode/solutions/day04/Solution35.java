package cn.yy.leetcode.solutions.day04;

/*
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 */


import java.util.Arrays;
import java.util.LinkedList;

public class Solution35 {

    public static int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        if (root.children == null){
            return 1;
        }
        int max = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            if (depth > max){
                max = depth;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        node1.children = new LinkedList<>(Arrays.asList(node2, node3, node4));
        node3.children = new LinkedList<>(Arrays.asList(node5,node6));
        System.out.println(maxDepth(node1));

    }

    public static int plusOne(int i){
        return i+1;
    }
}



