public class Practice {
    public static void main(String[] args) {
        int [] arr={2, 3, 2, 5, 3, 0, 1};
        int n=arr.length;
        int frq[]=new int[n];

        for(int i:arr){
            
            frq[i]++;
        }
        int ans[]=new int[frq.length];
        for(int i=0;i<n;i++){
            if(frq[i]>1){
                ans[i]=frq[i];
            }
        }
        for(int i:ans){
            System.out.println(i);
        }
        for(int i=0; i<n; i++){
            if(frq[i] > 0){
                System.out.println(i + " occurs " + frq[i] + " times");
            }
        }
    }
    
}
