package cn.yy.leetcode.day04;

import java.util.Arrays;

/*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] ints = {-1, 1, 2, 4};
        int i = t1(ints, 1);
        System.out.println(Arrays.toString(ints));
        System.out.println(i);
    }

    public static int t1(int[] arr,int val){
        //将数组中与val值不同的放左边，l记录新数组长度
        int l=0;
        for (int i=0;i<arr.length;i++){
            //循环 数组找出与val不同的，放在新数组中
            if (arr[i]!=val){
                arr[l++]=arr[i];
            }
        }
        return l;
    }
}
