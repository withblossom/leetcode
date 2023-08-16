package cn.yy.leetcode.solutions.day09;

/*
给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。

提示：

如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
所有的机票必须都用一次 且 只能用一次。
示例 1：

输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
示例 2：

输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */


import java.util.*;

public class Solution87 {
    LinkedList<String> list = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        list.clear();
        Map<String, TreeMap<String,Integer>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                TreeMap<String, Integer> treeMap = map.get(ticket.get(0));
                treeMap.put(ticket.get(1),treeMap.getOrDefault(ticket.get(1),0)+1);
            }else {
                TreeMap<String,Integer> treeMap = new TreeMap<>();
                treeMap.put(ticket.get(1),1);
                map.put(ticket.get(0),treeMap);
            }
        }
        list.addLast("JFK");
        findItinerary(tickets,map);
        return list;
    }
    public boolean findItinerary(List<List<String>> tickets,Map<String, TreeMap<String,Integer>> map) {
        if (list.size()==tickets.size()+1){
            return true;
        }
        String cur = list.getLast();
        if (map.containsKey(cur)){
            TreeMap<String, Integer> treeMap = map.get(cur);
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                Integer count = entry.getValue();
                if (count>0){
                    list.addLast(entry.getKey());
                    entry.setValue(entry.getValue()-1);
                    if (findItinerary(tickets,map)) {
                        return true;
                    }
                    entry.setValue(count);
                    list.removeLast();
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {

    }
}

