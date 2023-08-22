package cn.yy.leetcode.solutions.day12;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
 */


public class Solution116 {

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i >= j){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}

