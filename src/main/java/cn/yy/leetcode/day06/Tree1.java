package cn.yy.leetcode.day06;

import cn.yy.leetcode.day04.LinkedNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree1 {

    List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {

    }

//    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

    public void checkFun01(List<List<Integer>> lists, Node node, int deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (lists.size() < deep) {
            ArrayList<Integer> list = new ArrayList<>();
            lists.add(list);
        }
        lists.get(deep-1).add(node.value);
        checkFun01(lists,node.left,deep);
        checkFun01(lists,node.right,deep);
    }

    public void checkFun03(List<List<Integer>> lists,Node node){
        if (node==null) return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                Node n = queue.poll();
                list.add(n.value);
                if (n.left!=null) queue.addLast(n.left);
                if (n.right!=null) queue.addLast(n.right);
                size--;
            }
            lists.add(list);
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;
}
