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
 class Pair{
        TreeNode root;
        long val;
        Pair(TreeNode root,long val){
            this.root=root;
            this.val=val;
        }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            long min=queue.peek().val;
            long left=0;
            long right=0;
            for(int i=0;i<size;i++){
                long cur_id=queue.peek().val-min;
                TreeNode node=queue.peek().root;
                queue.poll();
                if(i==0) left=cur_id;
                if(i==size-1) right=cur_id;
                if(node.left!=null){
                    queue.offer(new Pair(node.left,cur_id*2+1));

                }
                if(node.right!=null){
                    queue.offer(new Pair(node.right,cur_id*2+2));
                }
                

            }
            ans=Math.max(ans,(int)(right-left+1));
            
        }
        return ans;
        
    }
}