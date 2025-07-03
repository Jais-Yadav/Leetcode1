public class TwoPPR4 {
// Leetcode Problem: https://leetcode.com/problems/subarray-sum-equals-k/
// Sliding Window Technique
// This problem can be solved using the sliding window technique to count subarrays with a sum equal to k.

// The idea is to use a two-pointer approach to find the number of subarrays with a sum less than or equal to k.
    public int atmost(int []nums, int goal){
                int n=nums.length;
        int l=0;
        int sum=0;
        int cnt=0;
        if(goal<0) return 0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            cnt+=(r-l+1);

        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);

        
    }
    
}
