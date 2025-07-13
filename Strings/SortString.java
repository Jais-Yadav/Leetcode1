import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Sorts the characters in a string based on their frequency in descending order.
 * If two characters have the same frequency, they are sorted by their natural order.
 */

public class SortString {
        public String frequencySort(String s) {
        StringBuilder ans=new StringBuilder();
        HashMap <Character,Integer> mpp=new HashMap<>();

        for(char ch:s.toCharArray()){
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        List<Character> ls=new ArrayList<>(mpp.keySet());
        ls.sort((obj1,obj2)->mpp.get(obj2)-mpp.get(obj1)); // decending order sorting
        for(char ch:ls){
            for(int i=0;i<mpp.get(ch);i++){
                ans.append(ch);
            }
        }


       return ans.toString(); 
    }
    
}
