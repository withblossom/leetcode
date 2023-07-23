package cn.yy.leetcode.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution7 {

    /*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名
     */

    public static ArrayList<int[]> partitionLabels(int[][] merge) {
        //左边界排序
        Arrays.sort(merge, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> list = new ArrayList<>();
        //合并区间左端
        int start = merge[0][0];
        //合并区间右端
        int end = merge[0][1];
        for (int i = 1; i < merge.length; i++) {
            if (end>=merge[i][0]){
                end = Math.max(end,merge[i][1]);
            }else {
                list.add(new int[]{start,end});
                start = merge[i][0];
                end = merge[i][1];
            }
        }
        list.add(new int[]{start,end});
        return list;
    }


    public static void main(String[] args) {
        ArrayList<int[]> list = partitionLabels(new int[][]{{1,4},{4,5}});
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
