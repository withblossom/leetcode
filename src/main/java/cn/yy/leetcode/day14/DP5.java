package cn.yy.leetcode.day14;

public class DP5 {
    /*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

     */

    //动态规划
    public static int uniquePaths(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[0][0] == 1 && obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        //最左边一竖是1,因为只往下走，若有障碍物，后面都为0
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        //最上边一横是1,因为只往右走,若有障碍物，后面都为0
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        //递推 dp[i][j] = dp[i-1][j] + dp[i][j-1]，若有障碍物，该位置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {

    }
}
