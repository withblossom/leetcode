package cn.yy.leetcode.solutions.day14;

/*
给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 */


public class Solution137 {

    public static int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i <= chars1.length; i++) {
            dp[i][0] =  i;
        }
        for (int i = 0; i <= chars2.length; i++) {
            dp[0][i] =  i;
        }
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i-1]  == chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


    public static void main(String[] args) {
        System.out.println(
            minDistance("s","a")
        );
    }
}

