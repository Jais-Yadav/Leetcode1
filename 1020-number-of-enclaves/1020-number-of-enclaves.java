class Solution {
        public void dfs(int row,int col,int[][] grid,int [][] vis){
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int delrow=-1;delrow<=1;delrow++){
            for(int delcol=-1;delcol<=1;delcol++){
                if(Math.abs(delrow)+Math.abs(delcol)!=1){
                    continue;
                }
                int nrow=row+delrow;
                int ncol=col+delcol;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    dfs(nrow,ncol,grid,vis);
                }
                
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
     int m=grid[0].length;
     int num=0;
     int [][]vis=new int[n][m];

     for(int i=0;i<m;i++){
        if(vis[0][i]==0 && grid[0][i]==1){
            dfs(0,i,grid,vis);
        }
        if(vis[n-1][i]==0 && grid[n-1][i]==1){
            dfs(n-1,i,grid,vis);
        }
     }
     for(int j=0;j<n;j++){
        if(vis[j][0]==0 && grid[j][0]==1){
            dfs(j,0,grid,vis);
        }
        if(vis[j][m-1]==0 && grid[j][m-1]==1){
            dfs(j,m-1,grid,vis);
        }
     }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(vis[i][j]==0 && grid[i][j]==1){
                        num+=1;
                    }
                }
            }

            return num;
    }
}