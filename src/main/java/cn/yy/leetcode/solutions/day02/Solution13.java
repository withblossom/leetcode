package cn.yy.leetcode.solutions.day02;

import java.util.Arrays;
/*
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"
输出: True
解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"
输出: False
示例 3:

输入: "abcabcabcabc"
输出: True
解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */


public class Solution13 {

    //如果 s 是重复字符串，两个s拼在一起，在中间部分肯定还可以找到s
    public static boolean repeatedSubstringPattern(String s) {
        //拼接
        StringBuilder builder = new StringBuilder(s + s);
        //删除收尾，避免找到原来的两个s
        builder.deleteCharAt(2*s.length()-1);
        builder.deleteCharAt(0);
        //寻找
        return builder.indexOf(s) != -1;
    }

    //KMP算法
    //构造前缀表（当前位置最长公共前后缀大小组成的数组）
    //前缀表中为零的部分就是一个重复串
    //当前字符串由多个重复串构成，那么字符串长度可以整除重复串长度
    public static boolean repeatedSubstringPattern1(String s) {
        int[] next = new int[s.length()];
        int j=0;
        for (int i = 1; i < s.length(); i++) {
            while (j>0&&s.charAt(j)!=s.charAt(i)){
                j=next[j-1];
            }
            if (s.charAt(j)==s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
        return next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0;
    }

    public static void main(String[] args) {
        String s = "babbabbabbabbab";
    }
}
