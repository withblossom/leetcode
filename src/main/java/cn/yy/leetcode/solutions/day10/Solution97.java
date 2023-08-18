package cn.yy.leetcode.solutions.day10;

/*
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明:

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
 */


import java.util.stream.IntStream;

public class Solution97 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            int j = (i + 1) % gas.length;
            while (rest >= 0 && j != i) {
                rest += gas[j] - cost[j];
                j = (j + 1) % gas.length;
            }
            if (rest >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
            }
        }
        if (sum < 0) {
            return -1;
        }
        if (min >= 0) {
            return 0;
        }
        for (int i = gas.length - 1; i >= 0; i--) {
            int temp = gas[i] - cost[i];
            min += temp;
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int start = 0;
        int curSum = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            int temp = gas[i] - cost[i];
            curSum += temp;
            total += temp;
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (total < 0) {
            return -1;
        }
        return start;
    }

    public static void hash(int val, int num) {
        System.out.println(val % num);
//        System.out.println(val >> mode);
        System.out.println(val & (num - 1));
    }

    public static void main(String[] args) {
        hash(41, 5);
    }
}

