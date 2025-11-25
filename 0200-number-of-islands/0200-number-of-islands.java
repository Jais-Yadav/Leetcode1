class Pair{
    int first;
    int second;
   public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}



class Solution {

    public void bfs(int row,int col,char[][] grid,int [][] vis){
        vis[row][col]=1;
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        q.add(new Pair(row,col));
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.poll();

            //for traversing the neighbour of the current node;
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                     if (Math.abs(delrow) + Math.abs(delcol) != 1) { 
                         continue;
                     }
                    int nrow=r+delrow;
                    int ncol=c+delcol;
                    if(nrow>=0 && nrow<n &&ncol>=0 &&ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][] vis=new int [n][m];
        int count=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                         count++;
                bfs(row,col,grid,vis);
                }
               
            }
        }

        return count;
    }
}