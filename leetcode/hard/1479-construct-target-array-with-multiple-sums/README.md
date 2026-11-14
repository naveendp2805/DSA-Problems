# Q3. Construct Target Array With Multiple Sums

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an array `target` of n integers. From a starting array `arr` consisting of `n` 1's, you may perform the following procedure :

- let x be the sum of all elements currently in your array.
- choose index i, such that 0 <= i < n and set the value of arr at index i to x.
- You may repeat this procedure as many times as needed.

Return `true`  *if it is possible to construct the*  `target`  *array from*  `arr` *, otherwise, return*  `false`.

 

Original
Java
 **Example 1:** 

```
Input: target = [9,3,5]
Output: true
Explanation: Start with arr = [1, 1, 1] 
[1, 1, 1], sum = 3 choose index 1
[1, 3, 1], sum = 5 choose index 2
[1, 3, 5], sum = 9 choose index 0
[9, 3, 5] Done

```

 **Example 2:** 

```
Input: target = [1,1,1,2]
Output: false
Explanation: Impossible to create target array from [1,1,1,1].

```

 **Example 3:** 

```
Input: target = [8,5]
Output: true

```

 

 **Constraints:** 

- n == target.length
- 1 <= n <= 5 * 104
- 1 <= target[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 21.09%)  
**Memory:** 54.7 MB (beats 74.78%)  
**Submitted:** 2026-11-14T06:35:49.682Z  

```java
class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for(int num : target) {
            pq.offer((long) num);
            sum += num;
        }

        while(true) {
            long max = pq.poll();
            long rem = sum - max;

            if(max == 1 || rem == 1) {
                return true;
            }

            if(rem == 0 || max <= rem) {
                return false;
            }

            long prev = max % rem;

            if(prev == 0) {
                return false;
            }

            sum = rem + prev;

            pq.offer(prev);
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/construct-target-array-with-multiple-sums/)