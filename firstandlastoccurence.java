public class firstandlastoccurence {
    private int lowerBound(int[]nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
     private int UpperBound(int[]nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int Lower=lowerBound(nums,target);
        int Upper=UpperBound(nums,target)-1;
        if(Lower==n || nums[Lower]!=target) return new int[]{-1,-1};
        return new int[]{Lower,Upper};
    }
}
