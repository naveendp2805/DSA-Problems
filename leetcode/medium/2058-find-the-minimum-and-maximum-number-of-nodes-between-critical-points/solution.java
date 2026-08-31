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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPoints = new ArrayList<>();

        ListNode prev = head, curr = head.next;
        int i=1;

        while(curr.next != null)
        {
            if((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val))
                criticalPoints.add(i);

            prev = curr;
            curr = curr.next;
            i++;
        }

        int n = criticalPoints.size();

        if(n < 2) return new int[] {-1, -1};

        int minDist = Integer.MAX_VALUE, maxDist = criticalPoints.get(n-1) - criticalPoints.get(0);

        for(i=1; i<n; i++)
            minDist = Math.min(minDist, criticalPoints.get(i) - criticalPoints.get(i-1));

        return new int[] {minDist, maxDist};
    }
}