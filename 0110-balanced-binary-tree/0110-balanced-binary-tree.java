/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        int m = check(root);
        if (m== -1) {
            return false;
            
        }
        return true;
    }

    private static int check(TreeNode root) {
        if (root == null) {   //base csae
            return 0;
        }  
        // post order traversal
        int lefth = check(root.left);
        int righth = check(root.right);

        if(Math.abs(lefth-righth)>1){
            return -1;
        }
        if(lefth == -1 || righth == -1){   // for those trees which have unbalanced nodes
            return -1;
        }
    
        return 1+ Math.max(lefth,righth);

        
    }
}