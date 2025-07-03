import java.util.*;
public class agressivecows {
    public static boolean Canweplace(int[] stalls,int mid,int k){
        //mid is the distance between the stalls to place the cows
        int countcow=1;
        int lastcow=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastcow>=mid){
                countcow++;
                lastcow=stalls[i];
            }
            if(countcow>=k){
                return true;
            }

        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n=stalls.length;
        int low=1;//min distance
        int high=stalls[n-1]-stalls[0]; //max distance
        int ans=1;
        while(low<=high){
            int mid=(low+high)/2;
            if(Canweplace(stalls,mid,k)==true){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
