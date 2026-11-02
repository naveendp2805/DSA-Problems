# Merge Two Sorted Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one  **sorted**  list. The list should be made by splicing together the nodes of the first two lists.

Return  *the head of the merged linked list*.

 

 **Example 1:** 

```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

```

 **Example 2:** 

```
Input: list1 = [], list2 = []
Output: []

```

 **Example 3:** 

```
Input: list1 = [], list2 = [0]
Output: [0]

```

 

 **Constraints:** 

- The number of nodes in both lists is in the range [0, 50].
- -100 <= Node.val <= 100
- Both list1 and list2 are sorted in non-decreasing order.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 7.79%)  
**Memory:** 43.8 MB (beats 88.28%)  
**Submitted:** 2026-11-02T16:05:45.282Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/merge-two-sorted-lists/)