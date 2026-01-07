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

    long Tsum = 0;
     long maxP = 0;

    // how to find the total sum of the Binart TREE
    private long TotalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long sum = root.val + TotalSum(root.left) + TotalSum(root.right);

        return sum;

    }

    private long subtreeSum(TreeNode root) {

        if (root == null) {
            return 0;
        }
        long subtree1 = root.val + subtreeSum(root.left) + subtreeSum(root.right);
        long subtree2 = Tsum - subtree1;

        maxP = Math.max(maxP, subtree2 * subtree1);

        return subtree1;

    }

    public int maxProduct(TreeNode root) {

        int MOD = 1_000_000_007;

        if (root == null) {
            return 0;

        }
       
        Tsum = TotalSum(root);

       
        subtreeSum(root);
        return (int)(maxP % MOD);

    }
}