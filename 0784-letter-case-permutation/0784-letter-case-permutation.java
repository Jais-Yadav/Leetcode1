class Solution {
    public void solve(int ind,List<String> ans,String s,String op){
        if(ind==s.length()){
            ans.add(op);
            return;
            }
            char ch=s.charAt(ind);
            if(Character.isLetter(ch)){
                String op1=op;
                String op2=op;
               op1 = op + Character.toLowerCase(s.charAt(ind));
               op2=op + Character.toUpperCase(s.charAt(ind));
               solve(ind+1,ans,s,op1);
               solve(ind+1,ans,s,op2);


            }else{
                String op1=op;
                op1+=s.charAt(ind);
                solve(ind+1,ans,s,op1);
            }
            
        
    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        
        String op="";
        solve(0,ans,s,op);
        return ans;
        
    }
}