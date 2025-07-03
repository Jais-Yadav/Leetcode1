import java.util.Stack;
class StockSpanner {
int ind;
Stack <int[]>st;
    public StockSpanner() {
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
