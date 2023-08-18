package cn.yy.leetcode.solutions.day09;

/*
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 */


import java.util.*;

public class Solution84 {

    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        lists.clear();
        findSubsequences(nums, 0);
        return lists;
    }

    public void findSubsequences(int[] nums, int start) {
        if (list.size() >= 2) {
            lists.add(new LinkedList<>(list));
        }
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            if (used[nums[i] + 100]) {
                continue;
            }
            if (!list.isEmpty() && nums[i] < list.getLast()) {
                continue;
            }
            used[nums[i] + 100] = true;
            list.addLast(nums[i]);
            findSubsequences(nums, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {

    }
}

