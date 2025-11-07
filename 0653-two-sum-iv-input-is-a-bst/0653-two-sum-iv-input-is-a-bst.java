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
 public class BSTIterator{
    Stack<TreeNode> st=new Stack<>();
    boolean reverse=true;
    public BSTIterator(TreeNode root,Boolean isReverse){
        reverse=isReverse;
        pushAll(root);
    }
    public int next(){
        TreeNode curr=st.pop();
        
        if(reverse==false)pushAll(curr.right);
        else pushAll(curr.left);

        return curr.val;
    }

    public void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse==true) {
                root=root.right;
            }else{
                root=root.left;
            }
        }
    }
 }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l=new BSTIterator(root,false); //next iterator;
        BSTIterator r=new BSTIterator(root,true); // before

        int i=l.next(); //next -> inorder
        int j=r.next(); //before -> reverse inorder
        while(i<j){
            if(i+j==k)return true;
            if(i+j<=k)i=l.next();
            else j=r.next();
        }
        return false;
    }
}