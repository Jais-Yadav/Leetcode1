import java.util.*;

//Top View of Binary Tree
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
class Pair{
    Node root;
    int hd;
    Pair(Node root,int hd){
        this.root=root;
        this.hd=hd;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList <Integer> ans=new ArrayList<>(); 
        if(root==null) return ans;
        Queue<Pair> que=new LinkedList<>();
        Map<Integer,Integer> mpp=new TreeMap<>(); // sort the map in ascending order of key
        que.add(new Pair(root,0));
        while(!que.isEmpty()){
            Pair el=que.poll();
            Node node=el.root;
            int order=el.hd;
            if(mpp.get(order)==null) mpp.put(order,node.data);
            if(node.left!=null){
                que.add(new Pair(node.left,order-1));
            }
                   if(node.right!=null){
                que.add(new Pair(node.right,order+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}