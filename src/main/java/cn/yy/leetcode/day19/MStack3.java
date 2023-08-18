package cn.yy.leetcode.day19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MStack3 {
    /*
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

示例 1:

输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；数字 2 找不到下一个更大的数；第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
提示:

1 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
     */

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        LinkedList<Integer> stack = new LinkedList<>();
        // 将两个数组拼接在一起
        for (int i = 0; i < nums.length * 2; i++) {
            // 新索引（拼接数组中）对应的原索引
            int imod = i % nums.length;
            while (!stack.isEmpty() && nums[imod] > nums[stack.peek()]) {
                int top = stack.pop();
                res[top] = nums[imod];
            }
            stack.push(imod);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                nextGreaterElements(new int[]{1, 2, 1})));
    }
}

