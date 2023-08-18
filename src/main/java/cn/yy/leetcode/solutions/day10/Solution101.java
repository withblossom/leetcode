package cn.yy.leetcode.solutions.day10;

/*
在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。

一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，
若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution101 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (Comparator.comparingInt(o -> o[0])));
        int start = points[0][0];
        int end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                start = points[i][0];
                end = points[i][1];
                count++;
                continue;
            }
            start = Math.max(points[i][0], start);
            end = Math.min(points[i][1], end);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}

