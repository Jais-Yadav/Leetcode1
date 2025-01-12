import java.util.*;

public class threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
       
        
        Set<List<Integer>> st=new HashSet<>();
        for(int i=0;i<n;i++){
            Set<Integer> tempset=new HashSet<>();

            for(int j=i+1;j<n;j++){
                int rem=-(nums[i]+nums[j]);
                if(tempset.contains(rem)){
                    List<Integer> temp=Arrays.asList(nums[i],nums[j],rem);//it is use to add the array element in the list
                    temp.sort(null); //sort list
                    st.add(temp); // for unique triplet we have to use set
                }
                tempset.add(nums[j]);
            }
            
           
        }
        List<List<Integer>> ls=new ArrayList<>(st);
        
        return ls;
    }
    
}
