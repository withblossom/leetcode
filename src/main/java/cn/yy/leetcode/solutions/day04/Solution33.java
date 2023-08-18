package cn.yy.leetcode.solutions.day04;

/*
给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution33 {

    public static TreeNode1 connect(TreeNode1 root) {
        if (root == null){
            return null;
        }
        ArrayDeque<TreeNode1> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 node = deque.removeFirst();
                if (!deque.isEmpty() && i != size - 1){
                    node.next = deque.getFirst();
                }
                if (node.left !=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
class TreeNode1{

    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1 next;

}



