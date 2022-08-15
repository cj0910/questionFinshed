package Exercises;

//import javax.swing.tree.TreeNode;
//Definition for a binary tree node.
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

public class searchBST_700 {
    public static void main(String[] args) {

    }
}

class Solution_700 {
    //递归，利用二叉搜索树
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val)
            return root;
        if(val < root.val)
            return searchBST(root.left,val);
        else
            return searchBST(root.right,val);
    }
}