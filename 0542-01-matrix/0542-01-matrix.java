class Pair{
    int row;
    int col;
    int step;
    public Pair(int row,int col,int step){
        this.row=row;
        this.col=col;
        this.step=step;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
         int n=mat.length;
       int m=mat[0].length;
       int [][] vis=new int[n][m];
       int [][] dis=new int[n][m];
       Queue<Pair> q=new LinkedList<>();
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(mat[i][j]==0){
                q.add(new Pair(i,j,0));
                vis[i][j]=1;
            }else{
                vis[i][j]=0;
            }
        }
       }

       while(!q.isEmpty()){
        int r=q.peek().row;
        int c=q.peek().col;
        int steps=q.peek().step;
        q.poll();
        dis[r][c]=steps;
        for(int delrow=-1;delrow<=1;delrow++){
            for(int delcol=-1;delcol<=1;delcol++){
                if(Math.abs(delrow)+Math.abs(delcol)!=1){
                    continue;
                }
                int nrow=r+delrow;
                int ncol=c+delcol;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol,steps+1));
                    vis[nrow][ncol]=1;
                }

            }
        }
       }

       return dis;

        
    }
}