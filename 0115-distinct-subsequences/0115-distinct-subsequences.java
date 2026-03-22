class Solution {
     public long func(int ind1,int ind2,String s,String t,long [][]dp){
        if(ind2<0)return 1;
        if(ind1<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s.charAt(ind1)==t.charAt(ind2)) return dp[ind1][ind2]=func(ind1-1,ind2-1,s,t,dp)+func(ind1-1,ind2,s,t,dp);
         return dp[ind1][ind2]=func(ind1-1,ind2,s,t,dp);
    }
    public int numDistinct(String s, String t) {
          int n=s.length();
        int m=t.length();
        long dp[][]=new long[n][m];
        for(long i[]:dp){
            Arrays.fill(i,-1);
        }
        return (int)func(n-1,m-1,s,t,dp);
    }
}