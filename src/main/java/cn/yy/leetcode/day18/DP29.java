package cn.yy.leetcode.day18;

import java.util.Arrays;

public class DP29 {
    /*
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    //动态规划
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        //第i天状态为j，所剩的最多现金为dp[i][j]
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //持有股票状态
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3] - prices[i]));
            //卖出股票
            dp[i][1] = dp[i - 1][0] + prices[i];
            //可以买入股票状态
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            //冻结期
            dp[i][3] = dp[i - 1][1];
        }
        return Math.max(dp[prices.length-1][1],Math.max(dp[prices.length-1][2],dp[prices.length-1][3]));
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 4,2}));
    }
}

