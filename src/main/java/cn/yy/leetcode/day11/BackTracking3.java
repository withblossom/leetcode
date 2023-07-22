package cn.yy.leetcode.day11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BackTracking3 {

    /*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]

     */
    static List<Integer> list = new LinkedList<>();
    static List<List<Integer>> lists = new LinkedList<>();

    public static void backTracking(int[] nums, boolean[] used) {
        if (list.size()== nums.length){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i=0;i< nums.length;i++){
            if (used[i]){
                continue;
            }
            used[i]=true;
            list.add(nums[i]);
            backTracking(nums,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }

    public static List<List<Integer>> permute(int[] nums){
        if (nums.length==0){
            return lists;
        }
        boolean[] used = new boolean[nums.length];
        backTracking(nums,used);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
