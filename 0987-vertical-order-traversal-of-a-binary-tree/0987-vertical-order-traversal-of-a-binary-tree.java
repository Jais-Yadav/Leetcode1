/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple {
    TreeNode node;
    int x; //col
    int y; //row

    Tuple(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mpp = new TreeMap<>();
        Queue<Tuple> queue=new LinkedList<>();
        queue.offer(new Tuple(root,0,0));
        while(!queue.isEmpty()){
                Tuple tuple=queue.poll();
                TreeNode node=tuple.node;
                int x=tuple.x;
                int y=tuple.y;

                if(!mpp.containsKey(x)) mpp.put(x,new TreeMap<>());
                if(!mpp.get(x).containsKey(y))mpp.get(x).put(y,new PriorityQueue<>());

                mpp.get(x).get(y).offer(node.val);
                if(node.left!=null)queue.offer(new Tuple(node.left,x-1,y+1));
                if(node.right!=null)queue.offer(new Tuple(node.right,x+1,y+1));

        }

        List<List<Integer>> ls=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys :mpp.values()){
            ls.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values()){
               while(!nodes.isEmpty()){
                 ls.get(ls.size()-1).add(nodes.poll());
               }
            }
        }
        return ls;

    }
}