package cn.yy.leetcode.solutions.day01;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    /*
给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
     */

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                int sum = i + i1;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int i1 : nums4) {
                int sum = i + i1;
                count+=map.getOrDefault(-sum,0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
    }

}
