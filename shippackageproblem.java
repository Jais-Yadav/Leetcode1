//least capacity to ship package within days

public class shippackageproblem {
    public int sum(int[] weights){
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        return sum;
    }
    //here we have to confirm the number of days is less than or equal to required days for the given capacity
    public int days(int []arr,int cap){
        int day=1;
        int load=0;
        for(int i=0;i<arr.length;i++){
            if(load+arr[i]>cap){
                day=day+1;
                load=arr[i];
            }else{
                load+=arr[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
        }
        int high=sum(weights);
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int noOfdays=days(weights,mid);
            if(noOfdays<=days){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
