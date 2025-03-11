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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode curren = head;
        if(curren==null || curren.next==null) return curren;
        while (curren != null) {
            if (curren.next!=null && curren.val == curren.next.val) { 
                 while(curren.next!= null && curren.val==curren.next.val)
               { curren = curren.next;}
               prev.next = curren.next;
            } 
              

            else {
                prev = prev.next;
                }

                curren = curren.next;
            } 
    return dummy.next;
    }
}