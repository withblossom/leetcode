package cn.yy.leetcode.solutions.day10;

/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳  1  步，然后跳  3  步到达数组的最后一个位置。
说明: 假设你总是可以到达数组的最后一个位置
 */


public class Solution95 {

    public static int jump(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        int hop = 0;
        int count = 1;
        int i = 0;
        while (true){
            int temp = hop;
            for (; i <= hop; i++) {
                temp = Math.max(temp,i+nums[i]);
                if (temp  >= nums.length-1){
                    return count;
                }
            }
            count++;
            hop = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}

