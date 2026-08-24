# Binary Prefix Divisible By 5

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a binary array `nums` (**0-indexed**).

We define `xi` as the number whose binary representation is the subarray `nums[0..i]` (from most-significant-bit to least-significant-bit).

- For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.

Return  *an array of booleans* `answer` *where* `answer[i]` *is* `true` *if* `xi` *is divisible by* `5`.

 

 **Example 1:** 

```
Input: nums = [0,1,1]
Output: [true,false,false]
Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
Only the first number is divisible by 5, so answer[0] is true.

```

 **Example 2:** 

```
Input: nums = [1,1,1]
Output: [false,false,false]

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 99.42%)  
**Memory:** 47.5 MB (beats 64.88%)  
**Submitted:** 2026-08-24T10:06:01.863Z  

```java
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int rem = 0;

        for(int num : nums)
        {
            rem = (2 * rem + num) % 5;

            res.add(rem == 0);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-prefix-divisible-by-5/)