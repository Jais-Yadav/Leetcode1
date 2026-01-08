class Pair{
    long  distance;
    int node;
    public Pair(long distance,int node){
        this.distance=distance;
        this.node=node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=(int)1e9+7;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=roads.length;
        for(int i=0;i<m;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            long wt=roads[i][2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->Long.compare(x.distance,y.distance));
        long [] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        int [] ways=new int [n];
        Arrays.fill(ways,0);
        ways[0]=1;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            long d=pq.peek().distance;
            int node=pq.peek().node;
            pq.poll();
            for(Pair it:adj.get(node)){
                int v=it.node;
                long wt=it.distance;
                if(d+wt<dist[v]){
                    dist[v]=d+wt;
                    ways[v]=ways[node];
                    pq.add(new Pair(dist[v],v));
                }else if(d+wt==dist[v]){
                    ways[v]=(ways[v]+ways[node])%mod;
                }
            }
        }
        return (ways[n-1])%mod;
    }
}