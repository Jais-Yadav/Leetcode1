public class SingleElement3 {
        public int[] singleNumber(int[] nums) {
        int n=nums.length;
        int xor=0;
        int rightmost=0;
        int [] arr=new int[2];
        int b1=0,b2=0;
        for(int i=0;i<n;i++){
            xor=xor^nums[i];
        }
        rightmost=(xor & xor-1)^xor;
        for(int i=0;i<n;i++){
            if((nums[i] & rightmost)!=0){
                b1=b1^nums[i];
            }
            else{
                b2=b2^nums[i];
            }
        }
        arr[0]=b1;
        arr[1]=b2;

        return arr;
        
    }
    
}
