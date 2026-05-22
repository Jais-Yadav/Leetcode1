class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int [] ans=new int [n];
        int rank=1;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            ans[i]=arr[i];
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(mpp.containsKey(arr[i])) continue;
            mpp.put(arr[i],mpp.getOrDefault(arr[i],rank++));
            
        }

        for(int i=0;i<n;i++){
            ans[i]=mpp.get(ans[i]);
        }

        return ans;
        
    }
}