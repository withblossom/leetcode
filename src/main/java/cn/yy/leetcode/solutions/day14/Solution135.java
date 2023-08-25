package cn.yy.leetcode.solutions.day14;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */


public class Solution135 {

    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int real = 0;
        for (int num : nums) {
            real += num;
            sum = Math.max(sum, real);
            real = Math.max(0, real);
        }
        return sum;
    }
    public int maxSubArray1(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            sum = Math.max(sum,dp[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(

        );
    }
}

