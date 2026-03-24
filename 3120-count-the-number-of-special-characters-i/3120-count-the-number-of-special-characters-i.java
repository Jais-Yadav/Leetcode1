class Solution {
    public int numberOfSpecialChars(String s) {
         int n=s.length();
        HashMap<Character,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(s.charAt(i),mpp.getOrDefault(i,0)+1);
        }
       
        int count=0;
        for(int i=0;i<n;i++){
            if(mpp.containsKey(Character.toLowerCase(s.charAt(i))) &&mpp.containsKey(Character.toUpperCase(s.charAt(i)))){
                count++;
                mpp.remove(s.charAt(i));
                mpp.remove(Character.toUpperCase(s.charAt(i)));
            }
        }
        
       return count; 
    }
}