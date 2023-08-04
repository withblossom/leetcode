package cn.yy.leetcode.solutions.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。
 */
public class Solution5 {
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = Integer.MIN_VALUE;
        while (l < r) {
            int areaT = Math.min(height[l], height[r]) * (r - l);
            area = Math.max(area, areaT);
            if (height[l] > height[r]) {
                while (l < r && height[r - 1] <= height[r]) {
                    r--;
                }
                r--;
            }else {
                while (l < r && height[l] >= height[l + 1]) {
                    l++;
                }
                l++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 3, 1, 2, 3, 2, 100, 3, 2}));
    }
}
