class Solution {
      public boolean func(int n,int target,int [][]dp,int []arr){
        if(target==0)return true;
        if(n==0) return arr[n]==target;
        if(dp[n][target]!=-1)return dp[n][target]==1?true:false;
        boolean ntake=func(n-1,target,dp,arr);
        boolean take=false;
        if(target>=arr[n]){
             take=func(n-1,target-arr[n],dp,arr);
        }
        dp[n][target]=ntake||take?1:0;
        return ntake||take;
    }
    public boolean canPartition(int[] arr) {
            int n=arr.length;
   
      int totalsum=0;
      for(int i=0;i<n;i++)totalsum+=arr[i];
      if(totalsum % 2!=0)return false;
      int target=totalsum/2;
         int dp[][]=new int[n][target+1];
      for(int []i:dp){
        Arrays.fill(i,-1);
      }

      return func(n-1,target,dp,arr);
        
    }
}