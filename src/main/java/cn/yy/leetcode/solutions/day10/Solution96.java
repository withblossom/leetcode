package cn.yy.leetcode.solutions.day10;

/*
给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。

以这种方式修改数组后，返回数组 可能的最大和 。
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution96 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        nums = IntStream.of(nums).boxed()
                .sorted((o1,o2)->Integer.compare(Math.abs(o2),Math.abs(o1)))
                .mapToInt(o->o)
                .toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0  && k > 0){
                nums[i] *=-1;
                k--;
            }
            sum += nums[i];
        }
        if (k%2==1){
            sum -= nums[nums.length-1];
            nums[nums.length-1]*=-1;
            sum += nums[nums.length-1];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Integer.compare(1, 2));
    }
}

