package cn.yy.leetcode.solutions.day06;

/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */


import java.util.Arrays;

public class Solution70 {

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target)>sum || (sum+target)%2!=0){
            return 0;
        }
        int left = target + ((sum - target) >> 1);
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i] ; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[left];
    }

    public static void main(String[] args) {
        int left = 3;
        int right = 1;
        System.out.println((right - left) >> 1);
    }
}


