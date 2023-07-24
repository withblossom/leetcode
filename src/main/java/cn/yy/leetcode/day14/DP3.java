package cn.yy.leetcode.day14;

public class DP3 {
    /*
给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

请你计算并返回达到楼梯顶部的最低花费。
     */

    public static int minCostClimbingStairs(int[] cost){
        //初始化,表示到达该处所花的费用
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 2; i < cost.length; i++) {
            //到达该处可以从前 1 级楼梯（i-1）或前 2 级楼梯（i-2）
            //费用 = 到达上个位置费用 + 上个位置到该处费用
            //去最小
            int dpi = Math.min(dp0 + cost[i-2],dp1 + cost[i-1]);
            dp0 = dp1;
            dp1 = dpi;
        }
        return dp1;
    }

    public static void main(String[] args) {
        
    }
}
