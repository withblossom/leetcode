package cn.yy.leetcode.day11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BackTracking2 {

    /*
        给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

        示例:

        输入: [4, 6, 7, 7]
        输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
        说明:

        给定数组的长度不会超过15。
        数组中的整数范围是 [-100,100]。
        给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况

     */
    static List<Integer> list = new LinkedList<>();
    static List<List<Integer>> lists = new LinkedList<>();

    public static void backTracking(int[] nums, int start) {
        HashSet<Integer> set = new HashSet<>();
        if (list.size() > 1) {
            lists.add(new LinkedList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])|| !list.isEmpty() && list.get(list.size() - 1) > nums[i]) {
                continue;
            }
            set.add(nums[i]);
            list.add(nums[i]);
            backTracking(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public static List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return lists;
    }

    public static void main(String[] args) {
        backTracking(new int[]{4, 7, 6, 7}, 0);
        System.out.println(lists);
    }
}
