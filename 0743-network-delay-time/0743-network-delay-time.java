class Pair{
    int distance;
    int node;
    public Pair(int distance,int node){
        this.distance=distance;
        this.node=node;
    }
}
// class tuple{
//     int distance;
//     int node;
//     int time;
//     tuple(int distance,int node,int time){
//         this.distance=distance;
//         this.node=node;
//         this.time=time;
//     }
// }
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=times.length;
        for(int i=0;i<m;i++){
            int u=times[i][0]-1;
            int v=times[i][1]-1;
            int wt=times[i][2];
            adj.get(u).add(new Pair(wt,v));
        }
        int [] dis=new int[n];
        Arrays.fill(dis,(int)1e9);
        dis[k-1]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        pq.add(new Pair(0,k-1));
        int time=0;
        while(!pq.isEmpty()){
            int d=pq.peek().distance;
            int node=pq.peek().node;
            pq.poll();
            
            for(Pair it:adj.get(node)){
                
                int wt=it.distance;
                int v=it.node;
                
                if(d+wt<dis[v]){
                    dis[v]=d+wt;
                   
                    pq.add(new Pair(d+wt,v));
                }
            }
            
        }
        for(int i=0;i<n;i++){
            if(dis[i]==(int)1e9) return -1;
            time=Math.max(dis[i],time);
        }
        return time;
    }
}