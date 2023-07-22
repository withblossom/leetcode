package cn.yy.leetcode.day04;

import java.util.Arrays;

/*
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
并返回其长度。如果不存在符合条件的子数组，返回 0。
 */
public class Solution3 {
    public static void main(String[] args) {
        int[] ints = {1, 1, 3, 4};
        int i = t1(ints, 4);
        System.out.println(i);
    }

    public static int t1(int[] arr, int s) {
        //左窗口索引
        int l = 0;
        //上一次窗口和
        int sum = 0;
        //目前最小窗口元素个数
        int minLen = Integer.MAX_VALUE;
        //实际窗口元素个数
        int realLen = 0;
        //每一轮窗口都往右边扩
        for (int i = 0; i < arr.length ;) {
            if (sum >= s) {
                if (realLen < minLen) {
                    minLen = realLen;
                    if (minLen == 1) {
                        break;
                    }
                }
                sum -= arr[l++];
            } else {
                realLen++;
                sum += arr[i++];
            }
        }
        return minLen;
    }
}
