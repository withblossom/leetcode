package cn.yy.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
        int[] arr = {1, 5, 3};
        int x = 2;
        int y = 3;
        int sum = 0;
        int dis = 0;
        if (y > x){
            int temp = x;
            x = y;
            y  = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            sum  +=  arr[i];
            if (i>=x-1 && i<y-1){
                dis+=arr[i];
            }
        }
        int reDis = sum - dis;
        System.out.println(Math.min(dis, reDis));
    }
}
