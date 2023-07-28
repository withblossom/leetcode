package cn.yy.leetcode.day17;

import java.util.List;

public class DP21 {
    /*
有N种物品和一个容量为V 的背包。第i种物品最多有Mi件可用，每件耗费的空间是Ci ，价值是Wi 。
求解将哪些物品装入背包可使这些物品的耗费的空间 总和不超过背包容量，且价值总和最大。
     */

    public static int testMultiPack(int[] weight, int[] value, int[] nums, int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        // 遍历物品
        for (int i = 0; i < weight.length; i++) {
            // 遍历背包容量
            for (int j = bagWeight; j >= weight[i]; j--) {
                // 遍历个数
                for (int k = 1; k <= nums[i] && j - k * weight[i] >= 0; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        int[] nums = new int[] {2, 3, 2};
        int bagWeight = 10;
        System.out.println(testMultiPack(weight, value, nums, bagWeight));

    }
}
