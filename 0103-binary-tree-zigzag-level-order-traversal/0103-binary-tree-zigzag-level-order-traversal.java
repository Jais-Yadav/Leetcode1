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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        int it=0;// iteration to check if the linked index is odd or even
        queue.offer(root);
        if(root==null) return result;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<size;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                ls.add(queue.poll().val);
            }
            if(it%2==0){
                result.add(ls);
            }else{
                Collections.reverse(ls);
                result.add(ls);
            }
            it++;
        }
        return result;
        
    }
}