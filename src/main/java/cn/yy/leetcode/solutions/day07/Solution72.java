package cn.yy.leetcode.solutions.day07;

/*
找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

只使用数字1到9
每个数字 最多使用一次
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution72 {

    static List<List<Integer>> lists = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        lists.clear();
        combinationSum3T(k,n,1);
        return lists;
    }

    public void combinationSum3T(int k, int n,int start) {
        if (list.size()==k){
            if (n==0){
                lists.add(new LinkedList<>(list));
            }
            return;
        }
        for (int i = start; i < 10 - (k - list.size()) + 1 && i <= n; i++) {
            list.push(i);
            combinationSum3T(k, n-i, i + 1);
            list.pop();
        }
    }

    public static void main(String[] args) {

    }
}


