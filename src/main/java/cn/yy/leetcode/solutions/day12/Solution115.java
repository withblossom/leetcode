package cn.yy.leetcode.solutions.day12;

/*
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 */


public class Solution115 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int num : nums) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {

    }
}

