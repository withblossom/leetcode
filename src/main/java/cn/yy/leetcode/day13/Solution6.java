package cn.yy.leetcode.day13;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution6 {

    /*
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。

示例：

输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8] 解释： 划分结果为 "ababcbaca", "defegde", "hijhklij"。 每个字母最多出现在一个片段中。 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
提示：

S的长度在[1, 500]之间。
S只包含小写字母 'a' 到 'z' 。
     */

    public static ArrayList<Integer> partitionLabels(String s) {
        int[] chars = new int[26];
        //统计每一个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] = i;
        }
        int left = 0, right = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 找到字符出现的最远边界
            right = Math.max(right, chars[s.charAt(i)]);
            if (i == right) {
                list.add(right - left + 1);
                left = i + 1;
            }
        }
        return list;
    }


    public static void main(String[] args) {

    }
}
