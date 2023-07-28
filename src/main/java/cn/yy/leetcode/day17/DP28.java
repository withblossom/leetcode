package cn.yy.leetcode.day17;

public class DP28 {
    /*
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1：

输入：k = 2, prices = [2,4,1]

输出：2 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2。

示例 2：

输入：k = 2, prices = [3,2,6,5,0,3]

输出：7 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4。随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

提示：

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
     */
    //动态规划
    public static int maxProfit(int[] prices, int k) {
        if (prices.length == 0) return 0;
        //0 第一次买入
        //1 第一次卖出
        //2 第二次买入
        //3 第二次卖出
        //....
        int[][] dp = new int[prices.length][2 * k];
        for (int i = 0; i < k; i++) {
            dp[0][2 * i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            for (int j = 2; j < 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k - 1];
    }

    public static int maxProfit1(int[] prices, int k) {
        if (prices.length == 0) return 0;
        int[] dp = new int[2 * k];
        for (int i = 0; i < k; i++) {
            dp[2 * i] = -prices[0];
        }
        for (int price : prices) {
            dp[0] = Math.max(dp[0], -price);
            dp[1] = Math.max(dp[1], dp[0] + price);
            for (int i = 2; i < 2 * k; i += 2) {
                dp[i] = Math.max(dp[i], dp[i - 1] - price);
                dp[i + 1] = Math.max(dp[i + 1], dp[i] + price);
            }
        }
        return dp[2 * k - 1];
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 2, 6, 5, 0, 3}, 2));
        System.out.println(maxProfit1(new int[]{3, 2, 6, 5, 0, 3}, 2));

    }
}

