class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {

    public void bfs(int sr,int sc,int [][] arr,int iniColor,int color){
        arr[sr][sc]=color;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        int n=arr.length;
        int m=arr[0].length;
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.poll();
            for(int delrow=-1;delrow<=1;delrow++){
                 for(int delcol=-1;delcol<=1;delcol++){
                    if(Math.abs(delrow)+Math.abs(delcol)!=1){
                        continue;
                    }
                    int nrow=r+delrow;
                    int ncol=c+delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && arr[nrow][ncol]!=0 && 
                    arr[nrow][ncol]==iniColor){
                        arr[nrow][ncol]=color;
                        q.add(new Pair(nrow,ncol));
                    }
                 }

            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int [][]arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=image[i][j];
            }
        }
        int iniColor=image[sr][sc];
        bfs(sr,sc,arr,iniColor,color);

        return arr;
        
    }
}