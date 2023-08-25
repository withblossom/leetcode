package cn.yy.leetcode.solutions.day14;

/*
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
如果不存在，则输出 -1。
 */


import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution143 {

    public int[] nextGreaterElements(int[] nums) {
        int[] r = new int[nums.length];
        Arrays.fill(r, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int im = i % nums.length;
            while (!stack.isEmpty() && nums[im] > nums[stack.peek()]) {
                int top = stack.pop();
                r[top] = nums[im];
            }
            stack.push(im);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(

        );
    }
}

