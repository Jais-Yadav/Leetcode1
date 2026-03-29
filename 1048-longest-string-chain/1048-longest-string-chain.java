class Solution {
    public boolean comparator(String s1,String s2){
        if(s1.length()!=s2.length()+1) return false;
        int l=0;
        int r=0;
        while(l<s1.length()){
            if(r<s2.length() && s1.charAt(l)==s2.charAt(r)){
                l++;
                r++;

            }
            else{
                l++;
            }
            if(l==s1.length() && r==s2.length()) return true;
        }

        return false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        int n=words.length;
        int [] dp=new int[n];
        Arrays.fill(dp,1);
        int maxi=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(comparator(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                }
            }

        }

        return maxi;
        
    }
}