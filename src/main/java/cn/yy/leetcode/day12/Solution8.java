package cn.yy.leetcode.day12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution8 {

    /*
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明:

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1: 输入:

gas = [1,2,3,4,5]
cost = [3,4,5,1,2]
输出: 3 解释:

从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。
示例 2: 输入:

gas = [2,3,4]

cost = [3,4,3]

输出: -1

解释: 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油。
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油。开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油。
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。
     */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //全程汽油与损耗 的差值之和
        int curSum = 0;
        //最小的汽油与损耗 的差值
        int min = Integer.MAX_VALUE; // 从起点出发，油箱里的油量最小值
        //从 0 开始，每过一站求汽油与损耗 的差值
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            curSum += rest;
            if (curSum < min) {
                min = curSum;
            }
        }
        //情况1：汽油与损耗 的差值之和为负，说明从哪都不可能到达
        if (curSum < 0) return -1;
        //情况2：汽油与损耗 的差值 ，最小值为正，正是我们要找的，直接返回坐标
        if (min >= 0) return 0;
        //情况3：curSum>=0 和 min<0
        //说明前面有一段和为负，那么后一段一定为正，找出为正一段的开始点，就是出发点
        for (int i = gas.length - 1; i >= 0; i--) {
            int rest = gas[i] - cost[i];
            min += rest;
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }
    public static int canCompleteCircuit10(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i< gas.length;i++){
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum<0){
                start = i+1;
                curSum = 0;
            }
        }
        return totalSum<0?-1:start;
    }


    public static void main(String[] args) {

    }
}
