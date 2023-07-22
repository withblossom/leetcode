package cn.yy.leetcode.day04;

import java.util.Arrays;

/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] ints = {-1, 1, 2, 4};
        int[] arr = t1(ints);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] t1(int[] arr){
        int length = arr.length;
        int[] ints = new int[length];
        int l,r;
        for (int i=0,j=length-1;i<j;){
            l=arr[i]*arr[i];
            r=arr[j]*arr[j];
            if (r>l){
                ints[j--]=r;
            }else if (l==r){
                ints[j--]=r;
                ints[j--]=l;
            }else {
                ints[i++]=l;
            }
        }
        return ints;
    }
}
