package cn.yy.leetcode.day16;

public class DP16 {
    /*
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4
所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。
     */

    public static int combinationSum4(int[] nums,int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 遍历背包
        for (int i = 0; i <= target; i++) {
            // 遍历物品
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {

    }
}
