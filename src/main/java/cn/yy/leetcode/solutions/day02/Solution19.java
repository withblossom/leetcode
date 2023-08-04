package cn.yy.leetcode.solutions.day02;

/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。

请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution19 {


    //双指针
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        //排序，方便去重
        Arrays.sort(nums);
        // a
        for (int i = 0; i < nums.length; i++) {
            // 对 a去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            //b
            int mid = i + 1;
            //c
            int end = nums.length - 1;
            while (mid<end) {
                int r = nums[mid] + nums[end] + nums[i];
                // 找到一组结果
                if (r == 0) {
                    lists.add(Arrays.asList(nums[mid] , nums[end] , nums[i]));
                    // 对 b去重
                    while (end > mid && nums[mid] == nums[mid + 1]) mid++;
                    // 对 c去重
                    while (end > mid && nums[end] == nums[end - 1]) end--;
                    mid++;
                    end--;
                //大了 ，c左移
                }else if (r>0){
                    end--;
                //小了 ，b右移
                }else {
                    mid++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
