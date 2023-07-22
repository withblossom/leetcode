package cn.yy.leetcode.day11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTracking1 {

    /*
    给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
     */

    static List<Integer> list = new LinkedList<>();
    static List<List<Integer>> lists = new LinkedList<>();

    public static void backTracking(int[] nums,int start){
        lists.add(new LinkedList<>(list));
        for (int i=start;i< nums.length;i++){
            if (i>start&&nums[i-1]==nums[i]){
                continue;
            }
            list.add(nums[i]);
            backTracking(nums,i+1);
            list.remove(list.size()-1);
        }
    }

    public static List<List<Integer>> subSets2(int[] nums){
        if (nums.length==0){
            return lists;
        }
        Arrays.sort(nums);
        backTracking(nums,0);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(subSets2(new int[]{1, 2, 2}));
    }
}
