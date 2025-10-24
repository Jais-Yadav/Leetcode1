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
    public int check(TreeNode root){
        if(root==null) return 0;
        int lf=check(root.left);
         if(lf==-1) return -1;
        int rg=check(root.right);
         if(rg==-1) return -1;
       
        if(Math.abs(lf-rg)>1)return -1;

        return 1+Math.max(lf,rg);


    }
    public boolean isBalanced(TreeNode root) {
        return check(root)!=-1;


    }
}