package cn.yy.leetcode.solutions.day14;

/*
给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。

示例 1: 输入: "bbbab" 输出: 4 一个可能的最长回文子序列为 "bbbb"。

示例 2: 输入:"cbbd" 输出: 2 一个可能的最长回文子序列为 "bb"。
 */


public class Solution140 {

    public static int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][chars.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(
                longestPalindromeSubseq("a")
        );
    }
}

