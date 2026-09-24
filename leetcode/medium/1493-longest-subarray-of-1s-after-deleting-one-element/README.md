# Longest Subarray of 1's After Deleting One Element

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary array `nums`, you should delete one element from it.

Return  *the size of the longest non-empty subarray containing only* `1` *'s in the resulting array*. Return `0` if there is no such subarray.

 

 **Example 1:** 

```
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

```

 **Example 2:** 

```
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

```

 **Example 3:** 

```
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 87.65%)  
**Memory:** 65.3 MB (beats 66.74%)  
**Submitted:** 2026-09-24T15:05:45.912Z  

```java
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0, res = 0, zeroes = 0;

        for(int j=0; j<n; j++)
        {
            if(nums[j] == 0)
                zeroes++;

            while(zeroes > 1)
            {
                if(nums[i] == 0)
                    zeroes--;
                i++;
            }

            res = Math.max(res, j - i);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)