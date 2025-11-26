class Pair{
    int row;
    int col;
    int time;
   public Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
   }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int tm=0;
        int count=0; //for fresh orange
        int [][]vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) count++;
            }
        }

        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            tm=Math.max(t,tm);
            q.poll();
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    if(Math.abs(delrow)+Math.abs(delcol)!=1){
                        continue;
                    }
                    int nrow=r+delrow;
                    int ncol=c+delcol;
                    if(nrow>=0 && nrow<n &&ncol>=0 && ncol<m && vis[nrow][ncol]==0 &&
                     grid[nrow][ncol]==1){
                        vis[nrow][ncol]=2;
                        q.add(new Pair(nrow,ncol,t+1));
                        cnt++;
                     }
                }
            }
        }
        if (cnt!=count) return -1;

        return tm;
    }
}