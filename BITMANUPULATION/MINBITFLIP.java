package BITMANUPULATION;

public class MINBITFLIP {
    public int minBitFlips(int start, int goal) {
        int ans=start^goal;
        int count=0;
        while(ans!=0){ //to count the number of bits that are different
            // we can use the property that ans & (ans-1) will turn off the rightmost set bit
            ans=ans & ans-1;
            count++;

        }
        return count;
        
    }
    
}
