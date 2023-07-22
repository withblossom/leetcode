package cn.yy.leetcode.day05;

import java.util.HashSet;

/*
    给定两个数组，编写一个函数来计算它们的交集。
 */
public class HashTable2 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2){

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> r = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                r.add(i);
            }
        }
        return r.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection1(int[] nums1, int[] nums2) {

        return null;
    }
}

