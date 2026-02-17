class Solution {
        public int func(int i,int j,int[][] matrix,int [][]dp){
        if(i==0 && j==0)return matrix[i][j];
        if(i<0 || j<0)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        
        int up=func(i-1,j,matrix,dp);
        int left=func(i,j-1,matrix,dp);

        int min=Math.min(up,left);
        if(min==Integer.MAX_VALUE)return dp[i][j]=Integer.MAX_VALUE;
        return dp[i][j]=matrix[i][j]+min;
    }
    public int minPathSum(int[][] matrix) {
            int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int []i:dp){
            Arrays.fill(i,-1);
        }

        return func(m-1,n-1,matrix,dp);
        
    }
}