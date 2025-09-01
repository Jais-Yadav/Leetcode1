import java.util.*;
public class SubsetsSum2 {
        public static void findSubsets(int ind,int [] arr,List<List<Integer>> ans,List<Integer>ls){
        ans.add(new ArrayList<>(ls));
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i-1]==arr[i]) continue;
            ls.add(arr[i]);
            findSubsets(i+1,arr,ans,ls);
            ls.remove(ls.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        findSubsets(0,nums,ans,new ArrayList<>());
        return ans;
        
    }
    
}
