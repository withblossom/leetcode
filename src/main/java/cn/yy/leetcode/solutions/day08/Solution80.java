package cn.yy.leetcode.solutions.day08;

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution80 {

    static LinkedList<String> list = new LinkedList<>();
    static List<List<String>> lists = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        lists.clear();
        partition(s,0);
        return lists;
    }

    public static void partition(String s,int start) {
        if (start>= s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (is(str)){
                list.addLast(str);
            }else {
                continue;
            }
            partition(s,i+1);
            list.removeLast();
        }
    }

    public static boolean is(String s){
        for (int i = 0,j=s.length()-1; i<j; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(partition("a"));
    }
}

