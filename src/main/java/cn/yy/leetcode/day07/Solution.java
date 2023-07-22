//package cn.yy.leetcode.Solution;
//
///*
//给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
//
//算法的时间复杂度应该为 O(log (m+n)) 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//public class Solution {
//    public static void main(String[] args) {
//        int[] t1 = {1,2};
//        int[] t2 = {-1,3};
//        System.out.println(findMedianSortedArrays(t1, t2));
//    }
//
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int mid = (nums1.length + nums2.length -1) / 2;
//        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
//        boolean is1Big = false;
//        int i = 0, j = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (i + j == mid) {
//                if (isEven) {
//                    if (nums1[i]>nums2[j])
//                    return (nums1[i] + nums2[j]) / 2.0;
//                }
//                return Math.min(nums1[i], nums2[j]);
//            }
//            if (nums1[i] > nums2[j]) {
//                j++;
//            } else {
//                i++;
//            }
//        }
//        if (i == nums1.length) {
//            if (isEven) {
//                return (nums2[mid - i + j] + nums2[mid - i + j + 1]) / 2.0;
//            }
//            return nums2[mid - i + j];
//        }
//        if (j == nums2.length) {
//            if (isEven) {
//                return (nums1[mid + i - j] + nums1[mid + i - j + 1]) / 2.0;
//            }
//            return nums1[mid + i - j];
//        }
//        return 0;
//    }
//}