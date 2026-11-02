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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode head = res;

        while(list1 != null && list2 != null)
        {
            int v1 = list1.val, v2 = list2.val;
            
            ListNode n;

            if(v1 < v2) {
                n = new ListNode(v1);
                list1 = list1.next;
            } else {
                n = new ListNode(v2);
                list2 = list2.next;
            }

            head.next = n;
            head = head.next;
        }

        while(list1 != null) {
            ListNode n = new ListNode(list1.val);
            list1 = list1.next;

            head.next = n;
            head = head.next;
        }

        while(list2 != null) {
            ListNode n = new ListNode(list2.val);
            list2 = list2.next;

            head.next = n;
            head = head.next;
        }

        return res.next;
    }
}