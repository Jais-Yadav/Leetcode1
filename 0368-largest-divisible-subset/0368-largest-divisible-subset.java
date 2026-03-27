class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int []dp=new int[n];
        int []parent=new int[n];

         Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int maxlen=1;
        int lastindex=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
                if(dp[i]>maxlen){
                    maxlen=dp[i];
                    lastindex=i;
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(parent[lastindex]!=lastindex){
            ans.add(nums[lastindex]);
            lastindex=parent[lastindex];
        }
         ans.add(nums[lastindex]);

        
         Collections.reverse(ans);
         return ans;
    }
}