import java.util.*;

class Solution {

    public int func(int i, int j, int[][] matrix, int[][] dp, boolean[][] vis) {

        int m = matrix[0].length;

        if (j < 0 || j >= m) return (int)1e9;

        if (i == 0) return matrix[0][j];

        if (vis[i][j]) return dp[i][j];

        int up = func(i - 1, j, matrix, dp, vis);
        int dl = func(i - 1, j - 1, matrix, dp, vis);
        int dr = func(i - 1, j + 1, matrix, dp, vis);

        vis[i][j] = true;

        return dp[i][j] = matrix[i][j] + Math.min(up, Math.min(dl, dr));
    }

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            min = Math.min(min, func(n - 1, j, matrix, dp, vis));
        }

        return min;
    }
}