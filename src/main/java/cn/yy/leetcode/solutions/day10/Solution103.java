package cn.yy.leetcode.solutions.day10;

/*
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution103 {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int end = 0;
        int start = 0;
        for (int i = 0; i <= end; i++) {
            int temp = s.lastIndexOf(chars[i]);
            if (temp > end) {
                end = temp;
            }
            if (i == end) {
                end++;
                list.add(end - start);
                start = end;
                if (end == s.length()) {
                    break;
                }
            }
        }
        return list;
    }
    public static List<Integer> partitionLabels1(String s) {
        List<Integer> list = new ArrayList<>();
        int[] ints = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ints[chars[i]-'a'] = i;
        }
        int end = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = ints[chars[i]-'a'];
            end = Math.max(temp,end);
            if (i == end) {
                end++;
                list.add(end - start);
                start = end;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println('z' - 'a');
    }
}

