public class TwoPPR2 {
    // Leetcode Problem: https://leetcode.com/problems/max-consecutive-ones-iii/
    // Sliding Window Technique
        public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int r=0;
        int max=0;
        int nums_zeros=0;

        while(r<n){
            if(nums[r]==0){
                nums_zeros+=1;
            }

            while(nums_zeros>k){
                if(nums[l]==0) nums_zeros-=1;
                l++; // Shrinking of l;
            }
            max=Math.max(max,r-l+1);
            r++; // Expanding of r;
        }

        return max;
        
    }
    
}
