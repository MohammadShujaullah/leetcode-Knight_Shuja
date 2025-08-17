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
    public ListNode insertionSortList(ListNode head) {
       ArrayList<Integer>list=new ArrayList<>();


         
        while (head != null) {
            list.add(head.val);
            head = head.next;
            

        }
        //head is null now 

         Collections.sort(list);

        ListNode ans=new ListNode(0);
        ListNode curr=ans;           // for every node there is a pointer like head is not a node but apointer , so if i want to mAKE alinkedlist i have to make first a node then take pointer on it 
        for (int val:list) {
           curr.next = new ListNode(val);
            curr = curr.next;
        }

        return ans.next;

    }
}