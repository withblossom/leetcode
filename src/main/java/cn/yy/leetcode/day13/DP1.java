package cn.yy.leetcode.day13;

public class DP1 {
    /*
    斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
    该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
    也就是： F(0) = 0，F(1) = 1 F(n) = F(n - 1) + F(n - 2)，其中 n > 1 给你n ，请计算 F(n)
     */

    public static int fab(int n) {
        if (n == 0 || n == 1) return n;
        //初始化
        int f0 = 0;
        int f1 = 1;
        //递推 fn = fn-1 + fn-2
        while (--n > 0) {
            f1 = f0 + f1;
            f0 = f1 - f0;
        }
        return f1;
    }

    public static int fab1(int n) {
        if (n == 0 || n == 1) return n;
        return fab1(n - 1) + fab1(n - 2);
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(fab(500000));
        System.out.println(System.currentTimeMillis()-l);
    }
}
