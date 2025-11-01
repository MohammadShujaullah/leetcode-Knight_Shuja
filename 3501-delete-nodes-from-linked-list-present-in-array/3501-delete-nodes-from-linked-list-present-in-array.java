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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> st = new HashSet<>();

        for (int i : nums) {
            st.add(i);

        }

        while (head != null && st.contains(head.val)) {

            head = head.next;

        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null ) {

            if (!st.contains(curr.val)) {
                prev = curr;
                curr = curr.next;

            } else {

                if (prev != null) {
                    prev.next = curr.next; //slip the curr node

                }
                curr = curr.next;
            }

        }

        return head;

    }
}