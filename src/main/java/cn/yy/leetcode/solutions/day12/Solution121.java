package cn.yy.leetcode.solutions.day12;

/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 */


public class Solution121 {

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i1 = robT(nums, 0, nums.length - 1);
        int i2 = robT(nums, 1, nums.length);
        return Math.max(i1, i2);
    }

    public static int robT(int[] nums, int start, int end) {
        if (start == end - 1) {
            return nums[start];
        }
        int[] dp = new int[end];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start + 1], nums[start]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3}));
    }
}

