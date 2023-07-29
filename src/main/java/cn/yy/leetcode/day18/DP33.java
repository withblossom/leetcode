package cn.yy.leetcode.day18;

import java.util.Arrays;

public class DP33 {
    /*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

示例：

输入：

A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：长度最长的公共子数组是 [3, 2, 1] 。
提示：

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
     */
    //动态规划
    public static int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int count = 0;
                int out = i;
                int in = j;
                while (out < nums1.length && in < nums2.length && nums1[out] == nums2[in]) {
                    count++;
                    out++;
                    in++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static int findLength1(int[] nums1, int[] nums2) {
        int res = 0;
        //初始化
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        //递推 dp[i][j] = dp[i - 1][j - 1] + 1
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return res;
    }

    public static int findLength2(int[] nums1, int[] nums2) {
        int res = 0;
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[j] = dp[j - 1] + 1;
                else
                    dp[j] = 0;
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findLength1(
                new int[]{0, 1, 2}, new int[]{1, 2, 0}));
    }
}

