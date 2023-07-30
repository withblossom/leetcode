package cn.yy.leetcode.day19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class MStack2 {
    /*
给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。

请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

示例 1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。

示例 2:
输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出-1 。

提示：

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 10^4
nums1和nums2中所有整数 互不相同
nums1 中的所有整数同样出现在 nums2 中
     */

    public static int[] nextGreaterElement(int[] nums1,int[] nums2) {
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                map.put(nums2[stack.pop()],nums2[i]);
            }
            stack.push(i);
        }
        int[] res1 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res1[i] = map.getOrDefault(nums1[i],-1);
        }
        return res1;
    }

    public static int[] nextGreaterElement1(int[] nums1,int[] nums2) {
        //递增栈
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        //nums1[i] -> i 的映射。方便在num2中找到相等值在num1的索引
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],i);
        }
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty()&& nums2[i] > nums2[stack.peek()]){
                int top = stack.pop();
                // num2[top] 在num1中
                if (map.containsKey(nums2[top])) {
                    // 找到num2[top] 在num1中对应坐标
                    int index = map.get(nums2[top]);
                    res[index] = nums2[i];
                }
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {2,4}, nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(
                nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(
                nextGreaterElement1(nums1, nums2)));
    }
}

