package cn.yy.leetcode.day14;

public class DP2 {
    /*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1 阶 + 1 阶
2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1 阶 + 1 阶 + 1 阶
1 阶 + 2 阶
2 阶 + 1 阶
     */

    public static int climbStairs(int n){
        if (n<=2)return n;
        //初始化
        int f1=1;
        int f2=2;
        //递推 fn = fn-1 + fn-2
        for (int i = 3; i <= n; i++) {
            f2 = f1 + f2;
            f1 = f2 - f1;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
