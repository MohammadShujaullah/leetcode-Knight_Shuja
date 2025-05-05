/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp=head;
        while(temp!=null){
            Node t=temp.next;
            if(temp.child!=null){
                Node c=flatten(temp.child);  //assume all works done by recusion(7,8,11,12,9,10)
                temp.next=c;                 // now connect the cto temp
                c.prev=temp;
                while(c.next!=null){
                    c=c.next;
                }
                c.next=t;
                 if(t!=null)
                  t.prev=c;
                                      
               
            }
            temp.child=null;    ///vvi
            temp=temp.next;
            

        }return head;
    }
}