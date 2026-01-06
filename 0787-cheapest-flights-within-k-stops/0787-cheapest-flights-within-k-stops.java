class Pair{
    int node;
    int cost;
    public Pair(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
}

class tuple{
    int stop;
    int node;
    int distance;
    public tuple(int stop,int node,int distance){
        this.stop=stop;
        this.node=node;
        this.distance=distance;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        
        int m=flights.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int wt=flights[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int []dis=new int [n];
        Arrays.fill(dis,(int)1e9);
        dis[src]=0;
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(0,src,0));

        while(!q.isEmpty()){
            int node=q.peek().node;
            int stop=q.peek().stop;
            int distance=q.peek().distance;
            q.poll();
            if(stop>k) continue;
            for(Pair it:adj.get(node)){
                int v=it.node;
                int cost=it.cost;
                if(distance+cost<dis[v]){
                    dis[v]=distance+cost;
                    q.add(new tuple(stop+1,v,dis[v]));
                }
            }
        }
        if(dis[dst]==(int)1e9) return -1;
        return dis[dst];
    }
}