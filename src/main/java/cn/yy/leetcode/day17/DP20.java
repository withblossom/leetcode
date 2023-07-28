package cn.yy.leetcode.day17;

import java.util.Arrays;
import java.util.List;

public class DP20 {
    /*
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。

你可以假设字典中没有重复的单词。

示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
     */

    public static boolean wordBreak(List<String> wordDict, String s) {
        //初始化
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //递推 dp[i] = wordDict.contains(s.substring(j, i)) && dp[j]
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak1(List<String> wordDict, String s) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() && dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    static boolean[] memo;

    public static boolean wordBreak2(List<String> wordDict, String s) {
        boolean[] memo = new boolean[s.length()];
        return backTracking(wordDict, s, 0);
    }

    public static boolean backTracking(List<String> wordDict, String s, int start) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start]) {
            return false;
        }
        for (int i = start; i < s.length(); i++) {
            if (wordDict.contains(s.substring(start, i + 1)) && backTracking(wordDict, s, i + 1)) {
                return true;
            }
        }
        memo[start] = true;
        return false;
    }


    public static void main(String[] args) {

    }
}
