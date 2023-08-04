package cn.yy.leetcode.solutions.day02;

import java.util.Arrays;
/*
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2

示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1

说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */


public class Solution12 {

    //KMP算法
    //j 公共部分前缀末尾，也是当前位置最长公共前后缀大小
    //next[] 最长公共前后缀大小
    public static int strStr(String haystack, String needle) {
        int j =0;
        int[] next = getNext(needle);
        for (int i = 1; i < haystack.length(); i++) {
            //不匹配
            while (j>0&&needle.charAt(j)!=haystack.charAt(i)){
                j=next[j-1];
            }
            //匹配
            if (needle.charAt(j)==haystack.charAt(i)){
                j++;
            }
            //文本串haystack里出现了模式串needle
            if (j==needle.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    //构造前缀表
    public static int[] getNext(String s){
        int[] next = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            // 前后缀不相同了
            while (j>0&&s.charAt(j)!=s.charAt(i)){
                // 向前回退
                j=next[j-1];
            }
            // 找到相同的前后缀
            if (s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNext("abcwabc")));
        System.out.println(strStr("abcd","cd"));
    }
}
