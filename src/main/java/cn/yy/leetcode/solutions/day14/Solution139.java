package cn.yy.leetcode.solutions.day14;

/*
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */


public class Solution139 {

    public int countSubstrings(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        count++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(

        );
    }
}

