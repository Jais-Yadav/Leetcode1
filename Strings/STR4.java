public class STR4 {
        public int maxDepth(String s) {
        int count=0;
        int maxcount=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                count++;
            }
            if(s.charAt(i)==')'){
                count--;
            }
            maxcount=Math.max(maxcount,count);
        }

        return maxcount;
        
    }
    
}
