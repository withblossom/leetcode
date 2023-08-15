package cn.yy.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[][] arr = new int[n][m];
//        int sum  = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = scanner.nextInt();
//                sum+=arr[i][j];
//            }
//        }
        int[][] arr = {{1, 1, 4}, {5, 1, 4}};
        int n = 2;
        int m = 3;
        int sum = 16;
        /*
        1 2 3 4
        5 6 7 8
         */
        int abs = Integer.MAX_VALUE;
        int real = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                real += arr[j][i];
            }
            int realAbs = Math.abs(sum - real -real);
            if (realAbs<abs){
                abs = realAbs;
            }
        }
        real = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                real += arr[i][j];
            }
            int realAbs = Math.abs(sum - real -real);
            if (realAbs<abs){
                abs = realAbs;
            }
        }
        System.out.println(abs);
    }
}
