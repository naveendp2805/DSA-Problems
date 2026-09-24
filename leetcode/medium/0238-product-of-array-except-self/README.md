# Product of Array Except Self

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, return  *an array*  `answer`  *such that*  `answer[i]`  *is equal to the product of all the elements of*  `nums`  *except*  `nums[i]`.

The product of any prefix or suffix of `nums` is  **guaranteed**  to fit in a  **32-bit**  integer.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

 

 **Example 1:** 

```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

```

 **Example 2:** 

```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

```

 

 **Constraints:** 

- 2 <= nums.length <= 105
- -30 <= nums[i] <= 30
- The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

 

 **Follow up:**  Can you solve the problem in `O(1)` extra space complexity? (The output array  **does not**  count as extra space for space complexity analysis.)

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 92.54%)  
**Memory:** 63.8 MB (beats 96.28%)  
**Submitted:** 2026-09-24T13:09:27.645Z  

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] res = new int[n];

        left[0] = 1;
        for(int i=0; i<n-1; i++)
            left[i+1] = left[i] * nums[i];

        res[n-1] = 1;
        for(int i=n-1; i>0; i--)
            res[i-1] = res[i] * nums[i];

        for(int i=0; i<n; i++)
            res[i] *= left[i];

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/product-of-array-except-self/)