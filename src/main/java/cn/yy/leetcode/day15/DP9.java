package cn.yy.leetcode.day15;

public class DP9 {
    /*
有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
     */

    //动态规划
    //滚动数组
    public static int testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        //dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagSize + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        //在使用二维数组的时候，递推公式：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
        //发现 递推公式中反复用到 dp[i-1],这表示该位置的上一个，也就是上一层，
        //二维数组到一维数组，也就是上一层到原来的值，
        //二维数组是我们用上一层来得到该层，一维数组是用原来的值得到现在的值
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[bagSize];
    }

    public static void main(String[] args) {

    }
}
