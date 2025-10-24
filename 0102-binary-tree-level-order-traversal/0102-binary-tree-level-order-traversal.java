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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size(); //Number of Node in queue
            List<Integer> subls=new ArrayList<>();
            for(int i=0;i<levelNum;i++){ //run for every node in the queue 
                if(queue.peek().left!=null)queue.offer(queue.peek().left); //check the left of the node and add it to the queue
                if(queue.peek().right!=null)queue.offer(queue.peek().right);//check the right of the node and add it to the queue
                subls.add(queue.poll().val);
            }
            ans.add(subls);

        }

        return ans;
        
    }
}