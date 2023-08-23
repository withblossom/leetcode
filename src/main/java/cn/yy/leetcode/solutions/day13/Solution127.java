package cn.yy.leetcode.solutions.day13;

/*
给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */


public class Solution127 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][3] - prices[i],dp[i-1][2] - prices[i]));
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][3],dp[i-1][2]);
            dp[i][3] = dp[i-1][1];
        }
        return Math.max(dp[dp.length-1][1],Math.max(dp[dp.length-1][2],dp[dp.length-1][3]));
    }

    public static void main(String[] args) {

    }
}

