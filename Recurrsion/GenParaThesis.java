import java.util.*;
public class GenParaThesis {
        public void Gen(List<String> ans,int open,int close,String op ){
        if(open == 0 && close==0){
            ans.add(op);
            return;
        }
        if(open!=0){
            String op1=op;
            op1+='(';
            Gen(ans,open-1,close,op1);
        }
        if(close>open){
            String op2=op;
            op2 +=')';
            Gen(ans,open,close-1,op2);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        String op="";
        int open=n;
        int close=n;
        Gen(ans,open,close,op);
        return ans;
        
    }
    
}
