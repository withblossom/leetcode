package cn.yy.leetcode.solutions.day06;

/*
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution68re {

    static ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        lists.clear();
        list.clear();
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] used = new boolean[target];
        return canPartitionKSubsets(nums, k, 0, target,used);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k, int start, int target,boolean[] used) {
        if (target == 0) {
            for (int integer : list) {
                if (used[integer]){
                    return false;
                }
            }
            for (int integer : list) {
                used[integer] = true;
            }
            lists.add(new LinkedList<>(list));
            return lists.size() == k;
        }
        for (int i = start; i < nums.length && nums[i] <= target; i++) {
            list.addFirst(nums[i]);
            if (canPartitionKSubsets(nums, k, i + 1, target - nums[i],used)) {
                return true;
            }
            list.removeLast();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }
}


