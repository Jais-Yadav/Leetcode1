
import java.util.ArrayList;
import java.util.List;

 class mergesort1 {
    public  void mergesort(int []arr,int low,int high){
            if (low>=high) return;
            int mid=(low+high)/2;
            mergesort(arr, low, mid);//left half
            mergesort(arr, mid+1, high);//right half
            merge(arr, low, mid, high);
        
    }
    public static  void merge(int []arr,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        List<Integer> Temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                Temp.add(arr[left]);
                left++;
            }else{
                Temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            Temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            Temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=Temp.get(i-low);
            
        }
    }
    
}
 public class solution{
 public static void main(String[] args) {
    int []arr={9, 4, 7, 6, 3, 1, 5};
    int n=arr.length;
    for(int i=0;i<n;i++){
        System.out.println(arr[i]+" ");

    }
    mergesort1 ob=new mergesort1();
    int low=0;
    int high=n-1;
    ob.mergesort(arr,low, high);
    System.out.println();
    System.out.println("after the  mergesort  ");
    for(int i=0;i<n;i++){
        System.out.println(arr[i]+" ");

    }
 }
}