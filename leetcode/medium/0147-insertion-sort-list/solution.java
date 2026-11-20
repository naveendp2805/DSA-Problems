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
        if(head == null) return head;

        ListNode dummy = new ListNode(-5001);
        dummy.next = head;

        ListNode lastSorted = head, curr = head.next;

        while(curr != null)
        {
            if(curr.val >= lastSorted.val) {
                lastSorted = curr;
                curr = curr.next;
            } else {

                ListNode next = curr.next;
                ListNode prev = dummy;

                while(prev.next.val <= curr.val) {
                    prev = prev.next;
                }

                lastSorted.next = next;

                curr.next = prev.next;
                prev.next = curr;

                curr = next;
            }
        }

        return dummy.next;
    }
}