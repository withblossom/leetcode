package cn.yy.leetcode.solutions.day13;

/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k笔 交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */


public class Solution126 {

    public int maxProfit(int[] prices,int k) {
        if (prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][2*k];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],- prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
            for (int j = 2; j < 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] - prices[i]);
                dp[i][j+1] = Math.max(dp[i-1][j+1],dp[i-1][j] + prices[i]);
            }
        }
        return dp[prices.length - 1][dp[0].length-1];
    }

    public static void main(String[] args) {

    }
}

