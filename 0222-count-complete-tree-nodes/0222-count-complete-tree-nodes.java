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
    public void count(TreeNode root,List<Integer> ls){
            if(root==null)return;
            ls.add(root.val);
            count(root.left,ls);
            count(root.right,ls);

    }
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        List<Integer> ls=new ArrayList<>();
        count(root,ls);
        return ls.size();


        
    }
}