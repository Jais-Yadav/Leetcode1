class Solution {
    public int func(int ind,int []coins,int [][]dp,int target){
        if(ind==0){
            if(target%coins[0]==0)return 1;
            else return 0;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int npick=func(ind-1,coins,dp,target);
        int pick=0;
        if(coins[ind]<=target){
             pick=func(ind,coins,dp,target-coins[ind]);
        }
        return dp[ind][target]=pick+npick;
    }
    public int change(int amount, int[] coins) {

        int n=coins.length;
         int dp[][]=new int[n][amount+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }

        return func(n-1,coins,dp,amount);

        
    }
}