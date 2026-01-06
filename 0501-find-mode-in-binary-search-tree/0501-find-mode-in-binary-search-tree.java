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
    private int currnum=0;
        private int currstreak=0;

    private int maxstreak=0;

    private List<Integer> result =new ArrayList<>();
    private void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(root.val==currnum){
            currstreak++;
        }
        else{
            currnum=root.val;
            currstreak=1;

        }
        if(currstreak>maxstreak){
            result.clear();
            maxstreak=currstreak;
        }
        if(currstreak==maxstreak){
            result.add(root.val);
        }
        dfs(root.right);
    }


    public int[] findMode(TreeNode root) {
        dfs(root);

        int [] resultarray = new int[result.size()];

        for(int i=0;i<result.size();i++){
            resultarray[i]=result.get(i);
        } 
        return resultarray;
    }
}