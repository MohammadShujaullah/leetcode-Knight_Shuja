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
class FindElements {

    HashSet<Integer> st = new HashSet<>(); // it is used to store all
    // the roots of the tree 

    private void DFS(TreeNode root, int x) {

        if (root == null) {
            return;
        }
        root.val = x;
        st.add(x);

        DFS(root.left, 2 * x + 1);
        DFS(root.right, 2 * x + 2);

    }

    public FindElements(TreeNode root) {
        st.clear();

        DFS(root, 0);

    }

    public boolean find(int target) {
        return st.contains(target);

    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */