package cn.yy.leetcode.day14;

public class DP7 {
    /*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     */

    //动态规划
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
