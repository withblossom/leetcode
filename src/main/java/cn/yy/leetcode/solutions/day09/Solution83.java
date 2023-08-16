package cn.yy.leetcode.solutions.day09;

/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution83 {

    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        lists.clear();
        Arrays.sort(nums);
        subsetsWithDup(nums,0);
        return lists;
    }
    public void subsetsWithDup(int[] nums,int start) {
        lists.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i>start&&nums[i]==nums[i-1]){
                continue;
            }
            list.push(nums[i]);
            subsetsWithDup(nums,i+1);
            list.pop();
        }
    }

    public static void main(String[] args) {

    }
}

