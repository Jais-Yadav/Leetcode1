
//Find Peak Element
public class peakelement {
    public int findPeakElement(int[] nums) {
        int n=nums.length;

        if(n==1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[n-1]>nums[n-2])return n-1;
        int low=1;
        int high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid+1]<nums[mid]){
                return mid;
            }else{
                if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]){
                    low=mid+1; // you are on the left part so the peak element occur at right
                }else{
                    high=mid-1;// you are on the right part so the peak element occur at left
                }
            }

        }
        return -1;
    }
}
