/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
          Queue<Node>q = new LinkedList<>();
         q.add(root);
        while(!q.isEmpty()){
            int n= q.size();
            List<Integer>list =new ArrayList<>();
            for(int i=0;i<n;i++){
                Node curr = q.remove();
                for(Node child : curr.children){
                    q.add(child);
                }
                list.add(curr.val);

            }
            result.add(list);
                  
                  
                  
                  
        }
        return result;


    }
}