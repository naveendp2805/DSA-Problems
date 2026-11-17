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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
        ListNode curr = head, repeat = head.next;

        while(curr != null)
        {
            while(repeat != null && repeat.val == curr.val) {
                repeat = repeat.next;
            }

            curr.next = repeat;
            curr = curr.next;
        }

        return head;
    }
}