package cn.yy.leetcode.solutions.day07;

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。
 */


import java.util.*;

public class Solution71 {

    static List<List<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
        lists.clear();
        combineT(n,k,1);
        return lists;
    }
    public static void combineT(int n, int k,int start) {
        if (list.size()==k){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n-(k-list.size())+1; i++) {
            list.push(i);
            combineT(n,k,i+1);
            list.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        System.out.println(list);
        System.out.println(lists);
    }
}


