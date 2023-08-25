package cn.yy.leetcode.solutions.day14;

/*
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */


public class Solution134 {

    public boolean isSubsequence(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (charsS[i - 1] == charsT[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

    public  static boolean isSubsequence1(String s, String t) {
        if ("".equals(s)){
            return true;
        }
        int i = 0;
        int j = 0;
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        while (j < charsT.length) {
            if (charsS[i] == charsT[j++]) {
                if (++i == charsS.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
            isSubsequence1("","ahbgdc")
        );
    }
}

