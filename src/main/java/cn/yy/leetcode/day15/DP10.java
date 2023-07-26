package cn.yy.leetcode.day15;

import java.util.Arrays;

public class DP10 {
    /*
题目难易：中等

给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200

示例 1:

输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
示例 2:

输入: [1, 2, 3, 5]
输出: false
解释: 数组不能分割成两个元素和相等的子集.
提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100
     */

    //动态规划
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 1) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        //nums数组和得为偶数
        if (sum % 2 == 1) {
            return false;
        }
        //01背包中，dp[j] 表示： 容量为j的背包，所背的物品价值最大可以为dp[j]
        //在本题中，j 表示总和也是 背包重量 ， num[i]是某个数 也是 物品重量和价值
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }

            if (dp[target] == target) {
                return true;
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        int[] num = {1,5,11,5};
        System.out.println(canPartition(num));
    }
}
