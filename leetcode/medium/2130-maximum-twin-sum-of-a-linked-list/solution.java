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
    public int pairSum(ListNode head) {
        ListNode sp = head, fp = head;
        ListNode prev = null;

        while(fp != null && fp.next != null)
        {
            fp = fp.next.next;
            ListNode next = sp.next;
            sp.next = prev;
            prev = sp;
            sp = next;
        }

        int res = 0;
        while(sp != null)
        {
            res = Math.max(res, prev.val + sp.val);
            sp = sp.next;
            prev = prev.next;
        }

        return res;
    }
}