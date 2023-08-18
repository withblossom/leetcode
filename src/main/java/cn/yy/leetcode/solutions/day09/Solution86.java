package cn.yy.leetcode.solutions.day09;

/*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution86 {

    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        lists.clear();
        Arrays.sort(nums);
        permute(nums,new boolean[nums.length]);
        return lists;
    }

    public void permute(int[] nums,boolean[] used) {
        if (list.size()== nums.length){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i>0&&nums[i]==nums[i-1]&&!used[i-1]){
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

