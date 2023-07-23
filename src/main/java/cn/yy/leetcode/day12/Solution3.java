package cn.yy.leetcode.day12;

public class Solution3 {

    /*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释:  连续子数组  [4,-1,2,1] 的和最大，为  6。
     */

    public static int maxSubArray(int[] nums){
        int res = Integer.MIN_VALUE;
        int r = 0;
        for (int num : nums) {
            r+=num;
            if (r>res){
                res = r;
            }
            if (r<0)r=0;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
