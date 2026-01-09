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


import java.util.*;
// mainly this question based on either left or right where the hight is larger ,
//// our subtree root will also be that side either right or left , then we have
//to find that root whose left giht and right hight are same , and thus this is the answer
class Solution {

  public int getDepth (TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right)); 
    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        int leftHeight = getDepth(root.left);
        int rightHeight = getDepth(root.right);

        if (leftHeight == rightHeight) {
            return root;
        }

        else if (leftHeight > rightHeight) {
            return subtreeWithAllDeepest(root.left);
        }
        return subtreeWithAllDeepest(root.right);

    }

    
}