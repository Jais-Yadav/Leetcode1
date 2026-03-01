class Solution {
        public int func(int n,int target,int []coins,int [][]dp){
            if(n==0){
                if(target%coins[n]==0)return target/coins[n];
                return (int)1e9;
            }
            if(dp[n][target]!=-1)return dp[n][target];
            int npick=0+func(n-1,target,coins,dp);
            int pick=Integer.MAX_VALUE;
            if(coins[n]<=target){
                pick=1+func(n,target-coins[n],coins,dp);
            }
            return dp[n][target]=Math.min(pick,npick);
    }
    public int coinChange(int[] coins, int amount) {
            int n=coins.length;
        int [][]dp=new int[n][amount+1];
        for(int i[]:dp)Arrays.fill(i,-1);
        int ans= func(n-1,amount,coins,dp);
        return ans>=(int)1e9?-1:ans;
        
    }
}