

public class SingleElement2 {
        public int singleNumber(int[] nums) {
        int n=nums.length;
        int ones=0;
        int twos=0;
        for(int i=0;i<n;i++){ // bucket method
            // ones will hold the bits that have appeared once  
            // twos will hold the bits that have appeared twice
            ones=(ones ^ nums[i]) & ~twos;
            twos=(twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
    
}
