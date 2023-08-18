package cn.yy.leetcode.day19;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MStack1 {
    /*
请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     */

    public static int[] dailyTemperatures(int[] temperatures) {
        // 递增栈
        // 栈中保存元素下标
        LinkedList<Integer> stack = new LinkedList<>();
        int[] dp = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // 元素大于栈顶元素（符合题目要求）
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // 接着弹出栈顶元素，获取下标，
                int top = stack.pop();
                // 获取栈顶元素 与 当前元素的距离
                dp[top] = i - top;
            }
            stack.push(i);
        }
        return dp;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

