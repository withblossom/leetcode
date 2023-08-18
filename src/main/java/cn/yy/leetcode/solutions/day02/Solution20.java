package cn.yy.leetcode.solutions.day02;

/*
题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，
判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution20 {


    //双指针
    public static List<List<Integer>> fourSum(int[] nums,int target) {
        List<List<Integer>> lists = new LinkedList<>();
        //排序，方便去重
        Arrays.sort(nums);
        //d
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            //三数去重逻辑
            //a
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int mid = j + 1;
                int end = nums.length - 1;
                while (mid < end) {
                    long r = (long) nums[mid] + nums[end] + nums[i] + nums[j];
                    // 找到一组结果
                    if (r == target) {
                        lists.add(Arrays.asList(nums[mid], nums[end], nums[i], nums[j]));
                        // 对 b去重
                        while (end > mid && nums[mid] == nums[mid + 1]) mid++;
                        // 对 c去重
                        while (end > mid && nums[end] == nums[end - 1]) end--;
                        mid++;
                        end--;
                        //大了 ，c左移
                    } else if (r > target) {
                        end--;
                        //小了 ，b右移
                    } else {
                        mid++;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}
