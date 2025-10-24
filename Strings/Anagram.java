import java.util.HashMap;

public class Anagram {
   
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mpp=new HashMap<>();

        for(int i=0;i<s.length();i++){
             mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
         

           
        }
        for(int i=0;i<t.length();i++){
               if(mpp.containsKey(t.charAt(i))){
                mpp.put(t.charAt(i),mpp.get(t.charAt(i))-1);
                if(mpp.get(s.charAt(i))==0) mpp.remove(s.charAt(i));
            }
        }

            if(mpp.isEmpty()) return true;

        return false;
        
    }

    
}
