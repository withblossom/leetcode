package cn.yy.leetcode.solutions.day08;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    ArrayList<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        lists.clear();
        combineT(n,k,1);
        return lists;
    }
    public void combineT(int n,int k,int start){
        if (k==list.size()){
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i =start;i<=n-(k-list.size())+1;i++){
            list.push(i);
            combineT(n,k,i+1);
            list.pop();
        }
    }
    public static void main(String[] args) {

    }
}

