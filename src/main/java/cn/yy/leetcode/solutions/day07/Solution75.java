package cn.yy.leetcode.solutions.day07;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution75 {

    static List<List<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists.clear();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        combinationSumT(candidates, target, 0, used);
        return lists;
    }

    public static void combinationSumT(int[] candidates, int target, int start, boolean[] used) {
        if (target == 0) {
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            list.push(candidates[i]);
            used[i] = true;
            combinationSumT(candidates, target - candidates[i], i + 1, used);
            used[i] = false;
            list.pop();
        }
    }

    public static void main(String[] args) {
        int[] ints = {8, 7, 4, 3};
        List<List<Integer>> lists = combinationSum(ints, 11);
        System.out.println(lists);
    }
}


