package cn.yy.leetcode.day05;

import java.util.Arrays;

/*
    给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Array2 {
    public static void main(String[] args) {
        int[][] draw = draw(1);
        print2Array(draw);
    }

    public static void print2Array(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] draw(int n) {
        int[][] ints = new int[n][n];
        //与最外层的偏离数
        int offline = 0;
        //累计数
        int start = 1;
        int half = n / 2;
        while (true) {
            if (start == n * n) {
                ints[offline][offline] = start;
                break;
            }
            if (offline>half){
                break;
            }
            for (int i = offline; i < n - 1 - offline; i++) {
                ints[offline][i] = start++;
            }
            for (int i = offline; i < n - 1 - offline; i++) {
                ints[i][n - 1 - offline] = start++;
            }
            for (int i = offline; i < n - 1 - offline; i++) {
                ints[n - 1 - offline][n - i - 1] = start++;
            }
            for (int i = offline; i < n - 1 - offline; i++) {
                ints[n - i - 1][offline] = start++;
            }
            offline++;
        }
        return ints;
    }

}

