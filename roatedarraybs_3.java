
//153. Find Minimum in Rotated Sorted Array
public class roatedarraybs_3 {
    public int findMin(int[] nums) {
        int n=nums.length;
        int target=Integer.MAX_VALUE;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            target=Math.min(target,nums[mid]);
            if(nums[mid]>nums[high]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
        return target;
    }
}
