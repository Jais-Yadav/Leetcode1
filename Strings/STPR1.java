
// remove outermost parentheses 
public class STPR1 {
        public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder ans=new StringBuilder();
        int n=s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i)==')'){
                count-=1;
            }

            if(count!=0){
                ans.append(s.charAt(i));
            }

            if(s.charAt(i)=='('){
                count++;
            }

        }
        return ans.toString();
        
    }
    
}
