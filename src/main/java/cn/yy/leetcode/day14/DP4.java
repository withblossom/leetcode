package cn.yy.leetcode.day14;

public class DP4 {
    /*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

     */

    //动态规划
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //初始化
        //最左边一竖是1,因为只往下走
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //最上边一横是1,因为只往右走
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //递推 dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //深度优先
    public static int uniquePaths1(int m, int n) {
        return traversal(1, 1, m, n);
    }
    public static int traversal(int i, int j, int m, int n) {
        if (i > m || j > n) return 0;
        if (i == m && j == n) return 1;
        return traversal(i + 1, j, m, n) + traversal(i, j + 1, m, n);
    }

    //数论
    public static int uniquePaths2(int m, int n) {
        //起点到finish 一共 m+n-2步
        int down = m + n - 2;
        //往下走的有 m-1 步
        //组合数
        int up = m - 1;
        int count = m - 1;
        int res = 1;
        while (count-- > 0) {
            res *= down--;
            while (up != 0 && res % up == 0) {
                res /= up--;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths1(3, 7));
        System.out.println(uniquePaths2(3, 7));
    }
}
