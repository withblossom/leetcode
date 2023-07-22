package cn.yy.leetcode.day03;

import java.util.Arrays;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int j = 1;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] != pre) {
                nums[j] = nums[i];
                pre = nums[j];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
