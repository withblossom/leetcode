package cn.yy.leetcode.solutions.day02;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9

所以返回 [0, 1]
 */


import java.util.HashMap;

public class Solution18 {

    public static int[] twoSum(int[] nums,int target){
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 差值 = 目标值 - 当前值
            int temp = target - nums[i];
            //哈希表中 存在nums[i], 说明之前放入过差值target - nums[?]
            if (map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            // 往哈希表中放入差值
            map.put(temp,i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
