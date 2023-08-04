package cn.yy.leetcode.solutions.day02;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。


 */


public class Solution16 {


    //双指针
    //一般 j 指向真实位置，i指向当前位置
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i]=0;
        }
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 4};

    }
}
