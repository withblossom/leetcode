package cn.yy.leetcode.solutions.day05;

/*
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
 */


import java.util.*;
import java.util.stream.Stream;

public class Solution54 {

    public int[] searchBST(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        searchBST(root, map);
        int max = map.values().stream().max(Comparator.naturalOrder()).get();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(o -> o).toArray();
    }

    public void searchBST(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        searchBST(root.left, map);
        searchBST(root.right, map);
    }

    int count = 0;
    public TreeNode pre;
    int realCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();
        findMode(root, list);
        return list.stream().mapToInt(o -> o).toArray();
    }

    public void findMode(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        findMode(root.left, list);
        if (pre == null) {
            realCount++;
        } else if (root.val == pre.val) {
            realCount++;
        } else {
            realCount = 1;
        }
        pre = root;
        if (realCount == count) {
            list.add(root.val);
        }
        if (realCount > count) {
            list.clear();
            list.add(root.val);
            count = realCount;
        }
        findMode(root.right, list);
    }

    public static void main(String[] args) {

    }
}



