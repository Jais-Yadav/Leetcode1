public class MINWINDOWSUBS {
     public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int sind=-1;
        int minLen=Integer.MAX_VALUE;
        int count=0,l=0,r=0;
        int [] hashMap=new int[256];
        for(int i=0;i<m;i++){
            hashMap[t.charAt(i)]++;
        }
        while(r<n){
            if(hashMap[s.charAt(r)]>0){
                count+=1;
                
            }
            hashMap[s.charAt(r)]--;
            while(count==m){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    sind=l;
                }
                hashMap[s.charAt(l)]++;
                if(hashMap[s.charAt(l)]>0)count-=1;
                l++;
            }
            r++;
        }
     

        return sind==-1?"":s.substring(sind,sind+minLen);
    }
    
}
