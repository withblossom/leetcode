package cn.yy.leetcode.solutions.day01;

import java.util.LinkedList;

/*
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。
 */
public class Solution6 {
    
    static LinkedList<Integer> list = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    public static int threeSumClosest(int[] nums, int target) {
        return 0;
    }
    
    public static void threeSumClosest(int[] nums, int target,int start) {
        if (list.size() == 3){
            if (target == 0){
                return;
            }
        }
    }
    
    

    public static void main(String[] args) {

    }
}
