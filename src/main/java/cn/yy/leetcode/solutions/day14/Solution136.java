package cn.yy.leetcode.solutions.day14;

/*
给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。

字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

题目数据保证答案符合 32 位带符号整数范围。
 */


public class Solution136 {

    public int numDistinct(String s, String t) {
        if (s.length() < t.length()){
            return 0;
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int[][] dp = new int[charsS.length + 1][charsT.length + 1];
        for (int i = 0; i < charsS.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= charsS.length; i++) {
            for (int j = 1; j <= charsT.length; j++) {
                if (charsS[i-1] == charsT[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[charsS.length][charsT.length];
    }
    public static void main(String[] args) {
        System.out.println(

        );
    }
}

