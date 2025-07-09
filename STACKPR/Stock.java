import java.util.Stack;
class Stock {
int ind;
Stack <int[]>st;
    public Stock() {
        ind=-1;
        st=new Stack<>();
        
    }
    
    public int next(int price) {
        ind++;
        while(!st.isEmpty()&& st.peek()[0]<=price){
            st.pop();
        }
        int ans=ind-(st.isEmpty()?-1:st.peek()[1]);
        st.push(new int[]{price,ind});
        return ans;
        
    }
}
