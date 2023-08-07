package cn.yy.leetcode.solutions.day07;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution74 {

    static List<List<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists.clear();
        combinationSumT(candidates, target, 0);
        return lists;
    }

    public static void combinationSumT(int[] candidates, int target, int start) {
        if (target == 0) {
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < candidates.length ; i++) {
            if (candidates[i] > target){
                continue;
            }
            list.push(candidates[i]);
            combinationSumT(candidates, target - candidates[i], i);
            list.pop();
        }
    }

    public static void main(String[] args) {
        int[] ints = {8, 7, 4, 3};
        List<List<Integer>> lists = combinationSum(ints, 11);
        System.out.println(lists);
    }
}


