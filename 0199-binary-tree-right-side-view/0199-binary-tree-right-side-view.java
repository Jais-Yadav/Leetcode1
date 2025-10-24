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
    public void rightSideCheck(List<Integer> ls,TreeNode root,int level){
        if(root==null)return;
        if(level==ls.size())ls.add(root.val);
        rightSideCheck(ls,root.right,level+1);
        rightSideCheck(ls,root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        rightSideCheck(ans,root,0);
        return ans;
    }
}