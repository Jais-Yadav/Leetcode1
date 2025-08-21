import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortArrByFreq {
    public int[] frequencySort(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int [] ans=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        List<Integer> ls=new ArrayList<>(mpp.keySet());
        // Sort the list based on frequency and then by value by using a custom comparator
       ls.sort((a, b) -> {
    int freqA = mpp.get(a);
    int freqB = mpp.get(b);
    if (freqA == freqB) return b - a; // larger number first
    return freqA - freqB; // lower frequency first
});


        for(int el:ls){
            for(int i=0;i<mpp.get(el);i++){
                ans[j++]=el;
            }
        }

        return ans;
        
    }
    
}
