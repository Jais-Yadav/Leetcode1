class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n=cost.length;
        int j=n-1;
        for(int i=0;i<j;i++){
            int temp=cost[i];
            cost[i]=cost[j];
            cost[j]=temp;
            j--;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            if(i%3!=2) sum+=cost[i];
        }

        return sum;
    }
}