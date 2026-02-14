class Solution {

    public int func(int i,int j,int [][] dp){
        if(i==0 && j==0)return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int left=func(i-1,j,dp);// up
        int right=func(i,j-1,dp);// left

        return dp[i][j]=left+right;

    }
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return func(m-1,n-1,dp);
        
    }
}