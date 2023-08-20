package cn.yy.leetcode.solutions.day11;

/*
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 */


public class Solution113 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zero = countZero(str);
            int one = str.length() - zero;
            for (int j = m; j >= zero; j--) {
                for (int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j - zero][k - one] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    public int countZero(String s){
        char[] chars = s.toCharArray();
        int count =0;
        for (char aChar : chars) {
            if (aChar   == '0'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}

