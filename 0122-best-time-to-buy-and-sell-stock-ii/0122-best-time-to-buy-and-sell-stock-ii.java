class Solution {
    public int func(int ind,int buy,int [][]dp,int []prices,int n){
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[ind]+func(ind+1,0,dp,prices,n),0+func(ind+1,1,dp,prices,n));
        }else{
        profit=Math.max(prices[ind]+func(ind+1,1,dp,prices,n),0+func(ind+1,0,dp,prices,n));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][]dp=new int[n][2];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return func(0,1,dp,prices,n);
    }
}