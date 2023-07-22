package cn.yy.leetcode.day03;

import java.util.*;
import java.util.stream.Collectors;

/*
给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：

        最高有效位 上的数字分配到 正 号。
        剩余每位上数字的符号都与其相邻数字相反。
        返回所有数字及其对应符号的和。
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(alternateDigitSum(123));
    }

    public static int t1(int n){
        int bit=0;
        int nn=n;
        //求n的位数 bit
        while (nn!=0){
            nn/=10;
            bit++;
        }
        int[] ints = new int[bit];
        for (int i=0;i<bit;i++){
            ints[i]=(int) Math.pow(-1,bit+i+1)*n%10;
            n/=10;
        }
        return Arrays.stream(ints).sum();
    }

    public static int alternateDigitSum(int n) {
        int ans = 0, t = 1;
        while(n != 0)
        {
            ans += t * (n % 10);
            System.out.println(ans);
            t = -t;
            n /= 10;
        }
        return -t * ans;

    }
}

