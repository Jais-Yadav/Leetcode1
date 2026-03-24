class Solution {
    public int lengthOfLastWord(String s) {
        String newString=s.trim();
        int n=newString.length();
        int l=0;
        for(int i=n-1;i>=0;i--){
            char ch=newString.charAt(i);
            if(Character.isLetter(ch)) l++;
            else return l;
        }

        return l;
    }
}