package cn.yy.leetcode.solutions.day14;

/*
给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。

请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 */


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collector;

public class Solution142 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],i);
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] r = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                    int top = stack.pop();
                    if (map.containsKey(nums2[top])){
                        int key = map.get(nums2[top]);
                        r[key] = nums2[i];
                    }
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            int top = stack.pop();
            if (map.containsKey(nums2[top])){
                int key = map.get(nums2[top]);
                r[key] = -1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(

        );
    }
}

