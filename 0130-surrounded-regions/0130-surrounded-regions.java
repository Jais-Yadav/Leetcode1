class Solution {
    public void dfs(int row, int col, char[][] board, int[][] vis) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        for (int delrow = -1; delrow <= 1; delrow++) {
            for (int delcol = -1; delcol <= 1; delcol++) {
                if (Math.abs(delrow) + Math.abs(delcol) != 1) {
                    continue;
                }
                int nrow = row + delrow;
                int ncol = col + delcol;
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0
                        && board[nrow][ncol] == 'O') {
                    dfs(nrow, ncol, board, vis);
                }
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        for (int i = 0; i < m; i++) {
            // for first row and all columns;
            if (vis[0][i] == 0 && board[0][i] == 'O') {
                dfs(0, i, board, vis);
            }

            //for last row and all columns
            if (vis[n - 1][i] == 0 && board[n - 1][i] == 'O') {
                dfs(n - 1, i, board, vis);
            }
        }

        for (int j = 0; j < n; j++) {
            // for first column and all rows
            if (vis[j][0] == 0 && board[j][0] == 'O') {
                dfs(j, 0, board, vis);
            }

            // for last column and all rows;
            if (vis[j][m - 1] == 0 && board[j][m - 1] == 'O') {
                dfs(j, m - 1, board, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        
    }
}