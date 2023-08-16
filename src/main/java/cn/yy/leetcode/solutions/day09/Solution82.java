package cn.yy.leetcode.solutions.day09;

/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution82 {

    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        lists.clear();
        subsets(nums,0);
        return lists;
    }
    public void subsets(int[] nums,int start) {
        lists.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.push(nums[i]);
            subsets(nums,i+1);
            list.pop();
        }
    }

    public static void main(String[] args) {

    }
}

