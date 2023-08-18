package cn.yy.leetcode.solutions.day02;

/*
给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
nums 的其余元素与 nums 的大小不重要。
返回 k
 */


public class Solution15 {


    //双指针
    //一般 j 指向真实位置，i指向当前位置
    public static int removeDuplicates(int[] nums) {
        int pre = nums[0];
        int j=1;
        for (int i = 1; i < nums.length; i++) {
            if (pre != nums[i]){
                nums[j++] = nums[i];
                pre = nums[i];
            }
        }
        return j;
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 4};

    }
}
