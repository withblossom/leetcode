package cn.yy.leetcode.solutions.day10;

/*
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意: 可以认为区间的终点总是大于它的起点。 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */


import java.util.Arrays;
import java.util.Comparator;

public class Solution102 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));
        int start = 0;
        int end = 0;
        int count = 0;
        for (int[] interval : intervals) {
            if (end == 0 || interval[0] >= end){
                count++;
                start = interval[0];
                end = interval[1];
                continue;
            }
            start = Math.max(interval[0], start);
            end = Math.min(interval[1], end);
        }
        return intervals.length - count;
    }
    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end){
                start = intervals[i][0];
                end = intervals[i][1];
                count++;
                continue;
            }
            start = Math.max(intervals[i][0], start);
            end = Math.min(intervals[i][1], end);
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {

    }
}

