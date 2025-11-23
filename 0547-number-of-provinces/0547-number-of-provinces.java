class Solution {

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,boolean []vis){
        vis[node]=true;
        for(int i:adj.get(node)){
            if(vis[i]==false){
                dfs(i,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        // for changing adjancecy matrix to adj list
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                adj.get(i).add(j);

                }
            }
        }
        boolean vis[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }
}