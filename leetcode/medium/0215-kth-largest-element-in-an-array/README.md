# Q1. Kth Largest Element in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the*  `kth`  *largest element in the array*.

Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

Can you solve it without sorting?

 

Original
Java
 **Example 1:** 

```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

```

 **Example 2:** 

```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

```

 

 **Constraints:** 

- 1 <= k <= nums.length <= 105
- -104 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 46 ms (beats 74.43%)  
**Memory:** 73.5 MB (beats 86.34%)  
**Submitted:** 2026-11-20T06:36:15.997Z  

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;

        for(int i=0; i<k; i++) {
            pq.offer(nums[i]);
        }

        for(int i=k; i<n; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/kth-largest-element-in-an-array/)