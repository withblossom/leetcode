package cn.yy.leetcode.solutions.day12;

/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */


import java.util.Arrays;

public class Solution118 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int temp = i*i;
            for (int j = temp; j <= n ; j++) {
                dp[j] = Math.min(dp[j],dp[j-temp]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}

