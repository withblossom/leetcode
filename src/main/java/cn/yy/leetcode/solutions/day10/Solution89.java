package cn.yy.leetcode.solutions.day10;

/*
编写一个程序，通过填充空格来解决数独问题。

一个数独的解法需遵循如下规则： 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 空白格用 '.' 表示。
 */


public class Solution89 {

    public void solveSudoku(char[][] board) {
        solveSudokuT(board);
    }
    public boolean solveSudokuT(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.'){
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board,i,j,k)){
                        board[i][j] = k;
                        if (solveSudokuT(board)){
                            return true;
                        }
                        board[i][j] =  '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num || board[row][i] == num) {
                return false;
            }
        }
        row = row / 3 * 3;
        col = col / 3 * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j]  == num){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

