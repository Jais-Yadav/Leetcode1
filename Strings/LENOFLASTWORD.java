public class LENOFLASTWORD {
    public int lengthOfLastWord(String s) {
         s=s.strip();
        int n=s.length();
       
       
        int len=0;
        for(int i=n-1;i>=0;i--){
            
            if(s.charAt(i)==' '){
                return len;
            }
            len++;
        }

        return len;
        
    }
    
}
