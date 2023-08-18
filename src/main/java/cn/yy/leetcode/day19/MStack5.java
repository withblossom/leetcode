package cn.yy.leetcode.day19;

import java.util.LinkedList;

public class MStack5 {
    /*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
     */

    public static int largestRectangleArea(int[] height) {
        //递减栈
        LinkedList<Integer> stack = new LinkedList<>();
        int volumn = 0;
        //在数组前后加 0；
        //数组开头的0 , 直接入栈，位置 -1
        stack.push(-1);
        //数组结尾的0，位置 height.length
        for (int i = 0; i <= height.length; i++) {
            int out = i == height.length ? 0 : height[i];
            while (stack.peek() != -1 && out < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = i - stack.peek() - 1;
                volumn = Math.max(volumn, w * h);
            }
            stack.push(i);
        }
        return volumn;
    }


    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 4}));
    }
}

