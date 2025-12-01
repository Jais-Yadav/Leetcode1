class Solution {
        public boolean check(int node,ArrayList<ArrayList<Integer>> adj,int [] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=0;
        while(!q.isEmpty()){
            int n=q.poll();
            
            for(int i:adj.get(n)){
                if(color[i]==-1){
                    color[i]=1-color[n];
                    q.add(i);
                }
                else if(color[i]==color[n]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int neighbor : graph[i]) {
                adj.get(i).add(neighbor);
            }
        }
        int V=adj.size();
        int [] color=new int[V];
      for(int i=0;i<V;i++)color[i]=-1;
      for(int i=0;i<V;i++){
        if(color[i]==-1){
            if(!check(i,adj,color)) return false;
        }
        
      }

      return true;

    }
}