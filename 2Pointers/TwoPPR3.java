public class TwoPPR3 {
// Leetcode Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
// Sliding Window Technique
       public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0,r=0;
        int maxlen=0;
        int maxFreq=0;
        int []freq=new int[26];
        while(r<n){
            freq[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq>k){
                freq[s.charAt(l)-'A']--;
                
                
                l++;
            }
            if((r-l+1)-maxFreq<=k) maxlen=Math.max(maxlen,r-l+1);
            r++;

        }
        return maxlen;
    }
    
}
