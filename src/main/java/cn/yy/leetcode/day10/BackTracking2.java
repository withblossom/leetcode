package cn.yy.leetcode.day10;

import java.util.LinkedList;
import java.util.List;

public class BackTracking2 {

    static List<Integer> list = new LinkedList<>();
    static List<List<Integer>> lists = new LinkedList<>();

    /*
    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。
     */
    public static void backTracking(int[] nums, int start) {
        lists.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2,2}));
    }
}
