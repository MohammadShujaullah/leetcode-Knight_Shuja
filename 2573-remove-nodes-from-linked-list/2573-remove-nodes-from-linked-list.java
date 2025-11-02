/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev; // reverse link
            prev = curr; // move prev
            curr = next; // move curr
        }

        return prev;  
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode revhead = reverse(head);

        ListNode curr = revhead;
        ListNode prev = curr;
        int max = curr.val;

        curr = curr.next;

        while (curr != null) {
            if (curr.val < max) {
                prev.next = curr.next;
            } else {
                max = curr.val;
                prev = curr;
            }
            curr = curr.next;
        }

        return reverse(revhead);
    }
}
