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
    // we used two pointer , one pointer is at first , second one traverse over it
    public ListNode mergeNodes(ListNode head) {

        ListNode p1 = head.next;
        ListNode p2 = p1;

        while (p2 != null) {
            int sum = 0;
            while (p2 != null && p2.val != 0) {
                sum += p2.val;
                p2 = p2.next;

            }
            p1.val = sum;
            p2 = p2.next;
            p1.next = p2;
            p1 = p1.next;

        }
        return head.next;
    }
}