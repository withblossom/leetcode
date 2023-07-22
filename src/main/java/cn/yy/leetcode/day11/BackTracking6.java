package cn.yy.leetcode.day11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BackTracking6 {

    /*
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：

输入：n = 1
输出：[["Q"]]
     */
    static LinkedList<int[][]> path = new LinkedList<>();

    public static void backTracking(int[][] chess,int n,int row) {
        if (row == n){
            path.addLast(copy2Arr(chess));
            return;
        }
        for (int i=0;i<n;i++){
            if (!isR(chess,row,i)){
                continue;
            }
            chess[row][i] = 1;
            backTracking(chess,n,row+1);
            chess[row][i] = 0;
        }
    }

    public static boolean isR(int[][] chess,int row,int col){
        for (int var = 0;var<row;var++){
            if (chess[var][col]==1){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (chess[i][j]==1){
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>=0&&j<chess.length;i--,j++){
            if (chess[i][j]==1){
                return false;
            }
        }
        return true;
    }

    public static int[][] copy2Arr(int[][] chess){
        int[][] newChess = new int[chess.length][chess.length];
        for (int i = 0; i < newChess.length; i++) {
            newChess[i] = Arrays.copyOf(chess[i],chess[i].length);
        }
        return newChess;
    }


    public static LinkedList<int[][]> solveNQueens(int n) {
        int[][] chess = new int[n][n];
        backTracking(chess,n,0);
        return path;
    }

    public static void main(String[] args) {
        LinkedList<int[][]> queens = solveNQueens(4);
        for (int[][] ints : queens) {
            for (int[] anInt : ints) {
                System.out.println(Arrays.toString(anInt));
            }
            System.out.println("---------------");
        }
    }
}
