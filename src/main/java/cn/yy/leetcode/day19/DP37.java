package cn.yy.leetcode.day19;

public class DP37 {
    /*
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

示例 1：

输入：s = "abc", t = "ahbgdc"
输出：true
示例 2：

输入：s = "axc", t = "ahbgdc"
输出：false
提示：

0 <= s.length <= 100
0 <= t.length <= 10^4
两个字符串都只由小写字符组成。
     */
    //动态规划
    public static boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

    //双指针
    public static boolean isSubsequence1(String s, String t) {
        int si = 0;
        int ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            } else {
                ti++;
            }
        }
        return si == s.length();
    }

    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc", s1 = "abc", t1 = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        System.out.println(isSubsequence(s1, t1));
        System.out.println(isSubsequence1(s, t));
        System.out.println(isSubsequence1(s1, t1));
    }
}

