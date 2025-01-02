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
 //Approach-2 - Tricky DFS (explained the trick on how to write such DFS)
//T.C : O(n)
//S.C : O(n)
class Solution {
    private void solve(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) {
            return;
        }

        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        solve(left.left, right.right, level + 1);
        solve(left.right, right.left, level + 1);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root.left, root.right, 1); // root is at level 0, left and right children at level 1
        return root;
    }
}