import java.util.ArrayList;
import java.util.List;

public class Permutation2 {
        public  void findPermutation(int ind,int [] arr,List<List<Integer>> ans){
        
        if(ind==arr.length){
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ls.add(arr[i]);
            }
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=ind;i<arr.length;i++){

                swap(ind,i,arr);
                findPermutation(ind+1,arr,ans);
                swap(ind,i,arr);
                
                
            
        }
    }
    private void swap(int i,int j,int []arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        
        findPermutation(0,nums,ans);
        return ans;

    }
    
}
