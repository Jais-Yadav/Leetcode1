class Solution {
        public int func(int ind,int buy,int cap,int []arr,int [][][]dp){
        int n=arr.length;
        if(cap==0)return 0;
        if(ind==n)return 0;
        if(dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];
        int profit=0;
        if(buy==1){
            profit=Math.max(-arr[ind]+func(ind+1,0,cap,arr,dp),0+func(ind+1,1,cap,arr,dp));
        }else{
            profit=Math.max(arr[ind]+func(ind+1,1,cap-1,arr,dp),0+func(ind+1,0,cap,arr,dp));
        }

        return dp[ind][buy][cap]= profit;
    }
    public int maxProfit(int[] arr) {
            int n=arr.length;
              int dp[][][]=new int [n][2][3];
        for(int i[][]:dp){
            for(int j[]:i){
            Arrays.fill(j,-1);
            }
           }

        return func(0,1,2,arr,dp);
        
    }
}