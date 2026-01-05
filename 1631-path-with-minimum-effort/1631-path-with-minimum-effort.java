class tuple{
    int distance;
    int row;
    int col;
    public tuple(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        int n=heights.length;
        int m=heights[0].length;
        int [][]dis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=(int)1e9;
            }
        }
        dis[0][0]=0;
        pq.add(new tuple(0,0,0));
        while(!pq.isEmpty()){
            int diff=pq.peek().distance;
            int r=pq.peek().row;
            int c=pq.peek().col;
             pq.poll();
            if(r==n-1 && c==m-1) return diff;
           
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    if(Math.abs(delrow)+Math.abs(delcol)!=1){
                        continue;
                    }
                    int nrow=r+delrow;
                    int ncol=c+delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newdiff=Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),diff);
                    if(newdiff<dis[nrow][ncol]){
                        dis[nrow][ncol]=newdiff;
                        pq.add(new tuple(newdiff,nrow,ncol));
                    }
                    }
                }
            }
        }
        return 0;
    }
}