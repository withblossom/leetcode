package cn.yy.leetcode.solutions.day06;

/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */


public class Solution66 {

    public static int numTrees(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}


