package cn.yy.leetcode.solutions.day06;

/*
组合
 */


public class Solution63 {

    public static int combinations1(int up, int down) {
        if (up > down >> 1) {
            up = down - up;
        }
        int upSum = 1;
        int downSum = 1;
        int newDown = down;
        for (int i = 0; i < up; i++) {
            upSum *= newDown--;
            downSum *= (i + 1);
        }
        return upSum / downSum;
    }

    public static long combinations(int up, int down) {
        if (up > down >> 2) {
            up = down - up;
        }
        long res = 1;
        int count = up;
        while (count-- > 0) {
            res *= down--;
            while (up != 0 && res % up == 0) {
                res /= up;
                up--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combinations(4, 5));
    }
}


