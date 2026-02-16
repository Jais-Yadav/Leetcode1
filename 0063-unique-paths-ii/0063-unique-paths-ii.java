class Solution {
    public int func(int m,int n,int [][] matrix,int[][] dp){
        if(m>=0 && n>=0 && matrix[m][n]==1)return 0;
        if(m==0 && n==0)return 1;
        if(m<0 || n<0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        int up=func(m-1,n,matrix,dp);
        int left=func(m,n-1,matrix,dp);
        return dp[m][n]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]dp=new int [m][n];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }

        return func(m-1,n-1,matrix,dp);

        
    }
}