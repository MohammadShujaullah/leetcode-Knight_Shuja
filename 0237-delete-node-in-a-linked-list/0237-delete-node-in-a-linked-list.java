/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // you have to delete the node value , not  node  in this questions
    public void deleteNode(ListNode node) {

        ListNode prev = null;

        ListNode curr = node;

        

        while (curr.next != null) {
             curr.val = curr.next.val;
            prev = curr;
            curr = curr.next;

        }

        if (curr.next == null) {
            prev.next = null;

        }

    }
}