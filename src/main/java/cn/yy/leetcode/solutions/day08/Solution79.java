package cn.yy.leetcode.solutions.day08;

/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。
示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]

示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution79 {
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

