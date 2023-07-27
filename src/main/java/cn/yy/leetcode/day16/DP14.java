package cn.yy.leetcode.day16;

public class DP14 {
    /*
有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大
     */

    //动态规划
    public static int testCompletePack(int[] weight, int[] value, int bagWeight) {
        //初始化
        int[] dp = new int[bagWeight + 1];
        //递推 dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i])
        for (int i = 0; i < weight.length; i++) {
            // 01背包和完全背包唯一不同就是体现在遍历顺序
            // 完全背包正序计算，可以利用之前计算过的值（已经放入当前物品），如果当前计算还要放入，就多次放入物品了，这正是完全背包
            // 01背包
            /*
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
             */
            //完全背包
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        System.out.println(testCompletePack(weight, value, bagWeight));
    }
}
