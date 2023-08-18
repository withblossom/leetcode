package cn.yy.leetcode.day16;

public class DP17 {
    /*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以 一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。

你有多少种不同的方法可以爬到楼顶呢？
     */

    public static int combinationSum4(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i >= j)
                    dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
