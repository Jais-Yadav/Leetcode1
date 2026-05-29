class Solution {
    public int numberOfSpecialChars(String s) {
        int n=s.length();
        int count=0;
        HashMap<Character,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            if(mpp.containsKey(s.charAt(i)) && Character.isUpperCase(s.charAt(i))) continue;
            mpp.put(s.charAt(i),i);
        }
        for(char ch='a';ch<='z';ch++){
            if(mpp.containsKey(ch) &&mpp.containsKey(Character.toUpperCase(ch))){
                if(mpp.get(ch)<mpp.get(Character.toUpperCase(ch))){
                    count++;
                    
                }
            }
        }
        return count;
    }
}