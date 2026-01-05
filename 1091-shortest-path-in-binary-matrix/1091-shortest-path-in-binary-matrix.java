class tuple{
    int d;
    int r;
    int c;
    public tuple(int d,int r,int c){
        this.d=d;
        this.r=r;
        this.c=c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         int n=grid.length;
        int m=grid[0].length;
       
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        if(n==1 && m==1 && grid[0][0]==0 ) return 1;
        Queue<tuple> q=new LinkedList<>();
        int [][] dis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=(int)1e9;
            }
        }
        dis[0][0]=1;
        q.add(new tuple(1,0,0));
        while(!q.isEmpty()){
            int d=q.peek().d;
            int r=q.peek().r;
            int c=q.peek().c;
            q.poll();
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                   
                    int nrow=r+delrow;
                    int ncol=c+delcol;
    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 && d+1<dis[nrow][ncol]){
                        dis[nrow][ncol]=d+1;
                        if(nrow==n-1 && ncol==n-1) return d+1;
                        q.add(new tuple(d+1,nrow,ncol));
                    }
                }
            }

        }

        return -1;
        
    }
}