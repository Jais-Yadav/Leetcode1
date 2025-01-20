import java.util.List;

public class roatedarraybs_4 {
        public int findKRotation(List<Integer> arr) {
        // Code here
        int n=arr.size();
        int low=0;
        int high=n-1;
        int count=0;
        int ans=0;
        int target=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            target=Math.min(target,arr.get(mid));// finding min in array

            if(arr.get(mid)>arr.get(high)){
                low=mid+1;
            }else{
                high=mid-1;
            }
           
        }
          while(arr.get(ans)>target){
                ans=ans+1;
                count++;
            }
        return count;
    }
}
