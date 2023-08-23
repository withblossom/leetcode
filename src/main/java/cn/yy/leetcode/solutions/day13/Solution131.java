package cn.yy.leetcode.solutions.day13;

/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */


import java.util.Arrays;

public class Solution131 {

    public static int findLength(int[] nums1, int[] nums2) {
        int count = 0;
        int real;
        for (int i = 0; i < nums1.length; i++) {
            int temp_i = i;
            for (int j = i; j < nums2.length; j++) {
                int temp_j = j;
                real = 0;
                while (true) {
                    if (temp_j == nums2.length){
                        count = Math.max(count, real);
                        break;
                    }
                    if (nums1[temp_i] == nums2[temp_j]) {
                        temp_i++;
                        temp_j++;
                        real++;
                    } else {
                        count = Math.max(count, real);
                        break;
                    }
                }
            }
        }
        return count;
    }
    public static int findLength1(int[] nums1, int[] nums2) {
        int count = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                    count = Math.max(dp[i][j],count);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
            findLength1(new int[]{3,2,1,4,7},new int[]{1,2,3,2,1})
        );
    }
}

