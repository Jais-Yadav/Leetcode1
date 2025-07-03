import java.util.PriorityQueue;

public class GasStationPr {
    public static class Pair{
        double first;
        int second;
        Pair(double first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static double MinimiseMaxDistance(int []arr, int K){
        // Write your code here.
        int n=arr.length;
        int[] howMany=new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        for(int i=0;i<n-1;i++){
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }
        for(int gs=1;gs<=K;gs++){
            Pair tp=pq.poll();
            int secondInd=tp.second;
            howMany[secondInd]++;
            double inidiff=arr[secondInd+1]-arr[secondInd];
            double newSec=inidiff/((double)howMany[secondInd]+1);
            pq.add(new Pair(newSec,secondInd));

        }
        return pq.peek().first;
    }
}
