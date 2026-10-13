# Maximum Alternating Sum of Squares

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums`. You may  **rearrange the elements**  in any order.

The  **alternating score**  of an array `arr` is defined as:

- score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 +...

Return an integer denoting the  **maximum possible alternating score**  of `nums` after rearranging its elements.

 

 **Example 1:** 

 **Input:**  nums = [1,2,3]

 **Output:**  12

 **Explanation:** 

A possible rearrangement for `nums` is `[2,1,3]`, which gives the maximum alternating score among all possible rearrangements.

The alternating score is calculated as:

`score = 22 - 12 + 32 = 4 - 1 + 9 = 12`

 **Example 2:** 

 **Input:**  nums = [1,-1,2,-2,3,-3]

 **Output:**  16

 **Explanation:** 

A possible rearrangement for `nums` is `[-3,-1,-2,1,3,2]`, which gives the maximum alternating score among all possible rearrangements.

The alternating score is calculated as:

`score = (-3)2 - (-1)2 + (-2)2 - (1)2 + (3)2 - (2)2 = 9 - 1 + 4 - 1 + 9 - 4 = 16`

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -4  *104 <= nums[i] <= 4*  104

## Solution

**Language:** Java  
**Runtime:** 31 ms (beats 93.66%)  
**Memory:** 135.4 MB (beats 37.32%)  
**Submitted:** 2026-10-13T06:18:22.930Z  

```java
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long res = 0;

        long[] squares = new long[n];

        for(int i=0; i<n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        int k = n / 2, i=0;

        for( ; i<k; i++) {
            res -= squares[i];
        }

        for( ; i<n; i++) {
            res += squares[i];
        }
        
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-alternating-sum-of-squares/)