package cn.yy.leetcode.day19;

import java.util.Arrays;

public class DP36 {
    /*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */

    public static int maxSubArray(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                r = Math.max(r, count);
            }
        }
        return r;
    }
    //贪心
    public static int maxSubArray1(int[] nums) {
        int r = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            r = Math.max(r, count);
            if (count <= 0) {
                count = 0;
            }
        }
        return r;
    }
    //动态规划
    public static int maxSubArray2(int[] nums) {
        //初始化
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int r = dp[0];
        //递推 dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            r = Math.max(r, dp[i]);
        }
        return r;
    }    //动态规划
    public static int maxSubArray3(int[] nums) {
        int count = nums[0];
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count = Math.max(count + nums[i],nums[i]);
            r = Math.max(r,count);
        }
        return r;
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

