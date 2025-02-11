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
    // we can solve this by using inorder traversal store in list and
    // then check it is it sorted or not
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderlist = new LinkedList<>();

        // now add node in list
        helper(root, inorderlist);
        int prev = inorderlist.get(0); // let the prev is smallest elemet
        for (int i = 1; i < inorderlist.size(); i++) {
            if (inorderlist.get(i) <= prev) {
                return false;
            }
            prev = inorderlist.get(i);

        }
        return true;

    }

    private void helper(TreeNode root, List<Integer> inorderlist) {
        if (root == null) {
            return;
        }
        helper(root.left, inorderlist);
        inorderlist.add(root.val);
        helper(root.right, inorderlist);
    }
}
/// time-->O(n)
  // space-->O(n)