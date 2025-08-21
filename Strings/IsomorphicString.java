import java.util.HashMap;
/**
 * Checks if two strings are isomorphic.
 * Two strings are isomorphic if the characters in one string can be replaced to get the other string.
 * Each character in the first string maps to exactly one character in the second string and vice versa.
 */

public class IsomorphicString {
    
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> mpp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(mpp.containsKey(s.charAt(i))){
                if(mpp.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
                
            }
            else if(mpp.containsValue(t.charAt(i))){
                return false;
            }

            mpp.put(s.charAt(i),t.charAt(i));
        }

        return true;
        
    }
}
    

