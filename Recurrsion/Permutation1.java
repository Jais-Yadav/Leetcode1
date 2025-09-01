import java.util.*;
public class Permutation1 {
        public static void findPermutation(int [] arr,List<List<Integer>> ans,boolean [] freq,List<Integer> ls){
        if(ls.size()==arr.length){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ls.add(arr[i]);
                findPermutation(arr,ans,freq,ls);
                ls.remove(ls.size()-1);
                freq[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean []freq=new boolean[nums.length];
        findPermutation(nums,ans,freq,new ArrayList<>());
        return ans;

    }
    
}
