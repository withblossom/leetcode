package cn.yy.leetcode.solutions.day09;

/*
按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */


import java.util.*;

public class Solution88 {

    ArrayList<List<String>> lists = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        lists.clear();
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        solveNQueens(chars, 0);
        return lists;
    }

    public void solveNQueens(char[][] chars, int row) {
        if (row == chars.length) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] aChar : chars) {
                list.add(new String(aChar));
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isValid(chars, row, i)) {
                chars[row][i] = 'Q';
                solveNQueens(chars, row + 1);
                chars[row][i] = '.';
            }
        }
    }

    public boolean isValid(char[][] chars, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chars.length; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}

