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
    List<List<Integer>> l = new ArrayList<>();

    public void fill(TreeNode root, int targetSum, int sum, List<Integer> list) {

        if (root == null)
            return;

        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == targetSum) {

            l.add(new ArrayList(list));

        }
        fill(root.left, targetSum, sum, list);
        fill(root.right, targetSum, sum, list);

        list.remove(list.size() - 1); // remove last element

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum = 0;

        List<Integer> list = new ArrayList<>();

        fill(root, targetSum, sum, list);

        return l;

    }
}