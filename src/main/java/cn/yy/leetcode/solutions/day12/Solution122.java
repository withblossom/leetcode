package cn.yy.leetcode.solutions.day12;

/*
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 */


import java.util.HashMap;
import java.util.HashSet;

public class Solution122 {

    public int rob(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.val;
        }
        int val1 = node.val;
        if (node.left != null) {
            val1 += rob(node.left.right) + rob(node.left.left);
        }
        if (node.right != null) {
            val1 += rob(node.right.right) + rob(node.right.left);
        }
        return Math.max(val1, rob(node.left) + rob(node.right));
    }

    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.val;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        int val1 = node.val;
        if (node.left != null) {
            val1 += rob(node.left.right) + rob(node.left.left);
        }
        if (node.right != null) {
            val1 += rob(node.right.right) + rob(node.right.left);
        }
        int max = Math.max(val1, rob(node.left) + rob(node.right));
        map.put(node, max);
        return max;
    }

    public int rob2(TreeNode node) {
        int[] dp = robT(node);
        return Math.max(dp[0],dp[1]);
    }
    public int[] robT(TreeNode node) {
        int[] dp = new int[2];
        if (node == null) {
            return dp;
        }
        int[] left = robT(node.left);
        int[] right = robT(node.right);
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
