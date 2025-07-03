import java.util.*;
// Leetcode Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class lenofDIstictsubstr {
       public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap <Character,Integer> mpp=new HashMap<>();
        int l=0;
        int r=0;
        int len=0;
        while(r<n){
            if(mpp.containsKey(s.charAt(r))){
                l=Math.max(l,mpp.get(s.charAt(r))+1);

            }

            len=Math.max(len,r-l+1);

            mpp.put(s.charAt(r),r);
            r++;
        }
        return len;
    }
    
}
