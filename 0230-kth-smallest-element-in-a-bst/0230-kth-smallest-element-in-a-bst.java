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
    public void findSmallest(TreeNode root,int k,TreeNode []ans,int []count){
        if(root==null)return;
        findSmallest(root.left,k,ans,count);
        count[0]++;
        if(count[0]==k){
            ans[0]=root;
            return;
        }
        findSmallest(root.right,k,ans,count);

        
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode []ans=new TreeNode[1];
        int count[]= new int[1];
       findSmallest(root,k,ans,count);

        return ans[0].val;
        
    }
}