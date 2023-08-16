package cn.yy.leetcode.solutions.day09;

/*
按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */


import java.util.*;

public class Solution88 {
    int count = 0;

    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        solveNQueens(lists, n, 0);
        return lists;
    }

    public void solveNQueens(ArrayList<List<String>> chess, int n, int start) {
        if (start == n + 1) {
            count++;
            return;
        }
        for (int i = start; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isValid(chess, i, j)) {
                    chess.get(i).set(j,"G");
                    solveNQueens(chess, n, i + 1);
                    chess.get(i).set(j,"");
                }
            }
        }
    }

    public boolean isValid(ArrayList<List<String>> chess, int i, int j) {
        for (int k = 0; k <= i; k++) {
            if ("G".equals(chess.get(k).get(j))) {
                return false;
            }
        }
        for (int k = j - 1, l = i - 1; k >= 0 && l >= 0; k--, l--) {
            if ("G".equals(chess.get(l).get(k))) {
                return false;
            }
        }
        for (int k = j + 1, l = i - 1; k < chess.size() && l >= 0; k++, l--) {
            if ("G".equals(chess.get(l).get(k))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}

