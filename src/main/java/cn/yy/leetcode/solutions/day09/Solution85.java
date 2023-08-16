package cn.yy.leetcode.solutions.day09;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution85 {

    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        lists.clear();
        permute(nums,new boolean[nums.length]);
        return lists;
    }

    public void permute(int[] nums,boolean[] used) {
        if (list.size()== nums.length){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            used[i]=true;
            list.addLast(nums[i]);
            permute(nums, used);
            list.removeLast();
            used[i]=false;
        }
    }

    public static void main(String[] args) {

    }
}

