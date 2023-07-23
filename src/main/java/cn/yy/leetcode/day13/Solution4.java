package cn.yy.leetcode.day13;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution4 {

    /*
在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。

一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。

示例 1：

输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2
解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
示例 2：

输入：points = [[1,2],[3,4],[5,6],[7,8]]
输出：4
示例 3：

输入：points = [[1,2],[2,3],[3,4],[4,5]]
输出：2
示例 4：

输入：points = [[1,2]]
输出：1
示例 5：

输入：points = [[2,3],[2,3]]
输出：1
提示：

0 <= points.length <= 10^4
points[i].length == 2
-2^31 <= xstart < xend <= 2^31 - 1
     */

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0)return 0;
        //有气球至少拿一根箭
        int arrow = 1;
        //升序
        Arrays.sort(points, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
//            //气球起点小于阈值，可以一起射
//            if (points[i][0]<=end){
//                //更新阈值，若该气球的右端小于阈值
//                end = Math.min(points[i][1], end);
//                continue;
//            }
//            //气球起点大于阈值，加一支箭
//            //更新阈值为气球的右端
//            end = points[i][1];
//            arrow++;
            if (end<points[i][0]){
                arrow++;
                end = points[i][1];
            }else {
                end = Math.min(end,points[i][1]);
            }
        }
        return arrow;
    }


    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
    }
}
