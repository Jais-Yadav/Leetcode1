class Solution {
        public int func(int ind,int e,int []nums,int []dp){
        if(ind>e)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int pick=nums[ind]+func(ind+2,e,nums,dp);
        int npick=0+func(ind+1,e,nums,dp);
        return dp[ind]=Math.max(pick,npick);
    }
    public int rob(int[] nums) {
    
             int n=nums.length;
             if(n==1)return nums[0];
        int []dp1=new int[n];
        Arrays.fill(dp1,-1);
        int []dp2=new int[n];
        Arrays.fill(dp2,-1);
        int case1=func(0,n-2,nums,dp1);
       int case2= func(1,n-1,nums,dp2);

        return Math.max(case1,case2);
    }
}