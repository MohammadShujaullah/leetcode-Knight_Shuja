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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // create a dummy node to mark the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // make marker for currnode for the node before reversing

        ListNode leftpre = dummy; // same as pointer
        ListNode currnode = head;

        for (int i = 0; i < left - 1; i++) {
            leftpre = leftpre.next; // just reach before the revesing start,
            currnode = currnode.next;

        }

        // make a marker to node where we start reversing
        ListNode sublisthead = currnode;
        ListNode prenode = null; // same as reversig the liked list code
        for (int i = 0; i < right - left+1; i++) {
            ListNode nextnode = currnode.next;
            currnode.next = prenode;

            // update
            prenode = currnode;
            currnode = nextnode;

        }

        // for joinning the peices
        leftpre.next = prenode;
        sublisthead.next = currnode;

        return dummy.next;


    }
}