package cn.yy.leetcode.solutions.day06;

/*
给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 */



public class Solution61 {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length<2){
            return 0;
        }
        int[] dp = new int[cost.length+1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2] );
        }
        return dp[dp.length-1];
    }
}


