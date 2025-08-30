import java.util.ArrayList;
import java.util.List;

public class CombinationSum{
        public static void findCombination(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ls){
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if(arr[ind]<=target){
            ls.add(arr[ind]); //pick the element
            findCombination(ind,arr,target-arr[ind],ans,ls);
            ls.remove(ls.size()-1); // Not Pick the element
        }
        findCombination(ind+1,arr,target,ans,ls);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombination(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }
}