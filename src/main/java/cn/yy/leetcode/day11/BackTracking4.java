package cn.yy.leetcode.day11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTracking4 {

    /*
        给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

        示例 1：

        输入：nums = [1,1,2]
        输出： [[1,1,2], [1,2,1], [2,1,1]]
        示例 2：

        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        提示：

        1 <= nums.length <= 8
        -10 <= nums[i] <= 10
     */
    static List<Integer> list = new LinkedList<>();
    static List<List<Integer>> lists = new LinkedList<>();

    public static void backTracking(int[] nums, boolean[] used) {
        if (list.size()== nums.length){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i=0;i< nums.length;i++){
            if (used[i] || i>0&&nums[i]==nums[i-1]&& !used[i - 1]){
                continue;
            }
            used[i]=true;
            list.add(nums[i]);
            backTracking(nums,used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }

    public static List<List<Integer>> permute(int[] nums){
        if (nums.length==0){
            return lists;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracking(nums,used);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
