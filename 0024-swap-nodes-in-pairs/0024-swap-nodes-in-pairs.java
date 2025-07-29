/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // create a dummy node to ease the thing
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;

        // ensure nodes we are swapping are not null

        while (point.next != null && point.next.next != null) {
            // identify nodes to swap
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            // actual swapping
            swap1.next = swap2.next;
            swap2.next = swap1;

            // prepare for next
            point.next = swap2;
            point = swap1;

        }
        // return the start head
        return dummy.next;

    }
}