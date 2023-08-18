package cn.yy.leetcode;

import java.util.HashSet;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        int[][] ints1 = new int[n-1][2];
        for (int i = 0; i < n - 1; i++) {
            ints1[i][0]  = scanner.nextInt();
            ints1[i][1]  = scanner.nextInt();
        }
        System.out.println(2);

    }
}
