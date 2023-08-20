package cn.yy.leetcode.solutions.day11;

/*
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution105 {

    public static int monotoneIncreasingDigits(int n) {
        StringBuilder builder = new StringBuilder(n + "");
        int index = builder.length() ;
        for (int i = index-2; i >= 0; i--) {
            if (builder.charAt(i)> builder.charAt(i+1)){
                index = i+1;
                builder.setCharAt(i, (char)(builder.charAt(i)-1));
            }
        }
        for (int i = index; i < builder.length(); i++) {
            builder.setCharAt(i,'9');
        }
        return Integer.parseInt(builder.toString());
    }
    public static int monotoneIncreasingDigits1(int n) {
        char[] chars = (n + "").toCharArray();
        int index = chars.length ;
        for (int i = chars.length-2; i >= 0; i--) {
            if (chars[i]> chars[i+1]){
                index = i+1;
                chars[i] -= 1;
            }
        }
        for (int i = index; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(341));
    }
}

