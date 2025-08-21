package Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>
{
    int key;
    int val;
    Pair(int key,int val){
        this.key=key;
        this.val=val;
    }

    @Override
   public int compareTo(Pair a){
        return Integer.compare(this.val,a.val);
    }

}
public class TopKElement {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Pair> minHeap=new PriorityQueue<>();
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int [] res=new int[k];
        int j=0;

        for(int i=0;i<n;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            minHeap.add(new Pair(entry.getKey(),entry.getValue()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            res[j++]=minHeap.poll().key;
        }

        return res;
        
    }
    
}
