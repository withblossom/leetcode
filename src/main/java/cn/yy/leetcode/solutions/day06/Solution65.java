package cn.yy.leetcode.solutions.day06;

/*
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */


public class Solution65 {

    public static int integerBreak(int n) {
        switch (n) {
            case 2:
                return 1;
            case 3:
                return 2;
        }
        int mul = 1;
        while (n > 4) {
            mul *= 3;
            n -= 3;
        }
        return mul * n;
    }

    //dp[i] = j*dp[i-j]
    public static int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}


