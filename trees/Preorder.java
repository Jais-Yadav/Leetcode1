import java.util.ArrayList;
import java.util.List;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
          this.right = right;
      }
  }

public class Preorder{
    public void Traversal(TreeNode root,List<Integer> ans){
        if(root==null)return;
        ans.add(root.val);
        Traversal(root.left,ans);
        Traversal(root.right,ans);
        
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Traversal(root,ans);
        return ans;
       
        
    }
  }