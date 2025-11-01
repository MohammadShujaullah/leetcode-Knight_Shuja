class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Convert array to a set for O(1) lookup
        HashSet<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        // Skip the nodes at the start of the list that are present in the set
        while (head != null && st.contains(head.val)) {
            head = head.next;
        }

        // Now process the rest of the list
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (!st.contains(curr.val)) {
                // Move prev and curr forward
                prev = curr;
                curr = curr.next;
            } else {
                // Skip the current node
                if (prev != null) {
                    prev.next = curr.next;
                }
                curr = curr.next;
            }
        }

        return head;
    }
}