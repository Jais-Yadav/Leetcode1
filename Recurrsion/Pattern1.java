import java.util.*;
public class Pattern1 {
        public static void  FindSubsets(int ind,int [] arr,int n,List<List<Integer>> ans,List<Integer> ds){
        if(ind==n){
            ans.add(new ArrayList<>(ds));
            return;

        }
        ds.add(arr[ind]);
        FindSubsets(ind+1,arr,n,ans,ds);  //take
        ds.remove(ds.size()-1);
         FindSubsets(ind+1,arr,n,ans,ds); //Dont take

    }
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        FindSubsets(0,nums,n,ans,new ArrayList<>());
        return ans;
        
    }
    
}
