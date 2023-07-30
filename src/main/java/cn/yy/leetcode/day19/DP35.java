package cn.yy.leetcode.day19;

import java.util.Arrays;

public class DP35 {
    /*
我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。

现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。

以这种方法绘制线条，并返回我们可以绘制的最大连线数。
     */
    //动态规划
    public static int longestCommonSubsequence(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[a.length][b.length];
    }    //动态规划

    //其实就是求两个数组的最长公共子序列的长度
    public static int longestCommonSubsequence1(int[] a, int[] b) {
        int[] dp = new int[b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            int pre = dp[0];
            for (int j = 1; j <= b.length; j++) {
                int cur = dp[j];
                if (a[i - 1] == b[j - 1])
                    dp[j] = pre + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                pre = cur;
            }
        }
        return dp[b.length];
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(longestCommonSubsequence1(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }
}

