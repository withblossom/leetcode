package cn.yy.leetcode.solutions.day11;

/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */


import java.util.Arrays;

public class Solution110 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        return canPartition(nums, 0,target);
    }

    public boolean canPartition(int[] nums,int start,int target) {
        if (target == 0){
            return true;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target){
                continue;
            }
            if (canPartition(nums, i+1, target-nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

