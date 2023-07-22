package cn.yy.leetcode.day11;

import java.util.Arrays;
import java.util.LinkedList;

public class BackTracking7 {

    /*
编写一个程序，通过填充空格来解决数独问题。

一个数独的解法需遵循如下规则： 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 空白格用 '.' 表示。
     */
    public static boolean backTracking(int[][] board) {
        //两层循环遍历每个方格
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //方格内有数，跳过
                if (board[i][j] == 0) {
                    continue;
                }
                //1-9中选个数填进去
                for (int v = 1; v <= 9; v++) {
                    //某个数不合法，下一个
                    if (!isR(board, v, i, j)) {
                        continue;
                    }
                    board[i][j] = v;
                    //填好这个了，递归填下一个
                    if (backTracking(board)) {
                        return true;
                    }
                    //递归失败，回退
                    board[i][j] = 0;
                }
                //这些数都试了，都不行
                return false;
            }
        }
        //方格填完了，成功
        return true;
    }

    public static boolean isR(int[][] board, int v, int row, int col) {
        //判断行
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] == v) {
                return false;
            }
        }
        //判断列
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == v) {
                return false;
            }
        }
        row = (row / 3) * 3;
        col = (col / 3) * 3;
        //判断九方格
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == v) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] solveSudokuHelper(int[][] board) {
        backTracking(board);
        return board;
    }

    public static void main(String[] args) {

    }
}
