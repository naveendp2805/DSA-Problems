# Single Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a  **non-empty**  array of integers `nums`, every element appears  *twice*  except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

 **Example 1:** 

 **Input:**  nums = [2,2,1]

 **Output:**  1

 **Example 2:** 

 **Input:**  nums = [4,1,2,1,2]

 **Output:**  4

 **Example 3:** 

 **Input:**  nums = [1]

 **Output:**  1

 

 **Constraints:** 

- 1 <= nums.length <= 3 * 104
- -3  *104 <= nums[i] <= 3*  104
- Each element in the array appears twice except for one element which appears only once.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 99.94%)  
**Memory:** 46.9 MB (beats 64.53%)  
**Submitted:** 2026-10-05T10:33:45.825Z  

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = nums[0];

        for(int i=1; i<nums.length; i++)
            res ^= nums[i];

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/single-number/)