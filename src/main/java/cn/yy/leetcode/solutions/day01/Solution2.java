package cn.yy.leetcode.solutions.day01;


import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {
    /*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int mid = i + 1;
            int end = nums.length - 1;
            while (end > mid) {
                int r = nums[i] + nums[mid] + nums[end];
                if (r == 0) {
                    lists.add(new LinkedList<>(Arrays.asList(nums[i], nums[mid], nums[end])));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (end > mid && nums[end] == nums[end - 1]) end--;
                    while (end > mid && nums[mid] == nums[mid + 1]) mid++;
                    end--;
                    mid++;
                } else if (r > 0) {
                    end--;
                } else {
                    mid++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
    }

}
