package cn.yy.leetcode.day17;

import java.util.HashMap;

public class DP24 {
    /*
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     */

    public static int rob(Node node) {
        if (node == null) {
            return 0;
        }
        int money = node.val;
        if (node.left != null) {
            money += rob(node.left.left) + rob(node.left.right);
        }
        if (node.right != null) {
            money += rob(node.right.left) + rob(node.right.right);
        }
        return Math.max(money, rob(node.left) + rob(node.right));
    }

    public static int rob1(Node node, HashMap<Node, Integer> map) {
        if (node == null) {
            return 0;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        int money = node.val;
        if (node.left != null) {
            money += rob1(node.left.left, map) + rob1(node.left.right, map);
        }
        if (node.right != null) {
            money += rob1(node.right.left, map) + rob1(node.right.right, map);
        }
        int max = Math.max(money, rob1(node.left, map) + rob1(node.right, map));
        map.put(node, max);
        return max;
    }

    public static int rob2(Node node) {
        if (node == null) {
            return 0;
        }
        int[] dp = robTree(node);
        return Math.max(dp[0], dp[1]);
    }

    public static int[] robTree(Node node) {
        //下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
        int[] dp = new int[2];
        if (node == null) {
            return dp;
        }
        int[] left = robTree(node.left);
        int[] right = robTree(node.right);
        //不偷当前节点，那么左右孩子就可以偷，至于到底偷不偷一定是选一个大的
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //如果是偷当前节点，那么左右孩子就不能偷
        dp[1] = left[0] + right[0] + node.val;
        return dp;
    }


    public static void main(String[] args) {


    }
}

class Node {
    int val;
    Node left;
    Node right;
}
