package cn.yy.leetcode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();

    }
    public boolean test(int[] arr, int x, int y) {
        int xIndex = -2, yIndex = -2;
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                xIndex = i;
            }
            if (y == arr[i]) {
                yIndex = i;
            }
        }
        System.out.println();
        return Math.abs(xIndex - yIndex) == 1;
    }
}
