# Max Consecutive Ones III

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary array `nums` and an integer `k`, return  *the maximum number of consecutive* `1` *'s in the array if you can flip at most*  `k` `0`'s.

 

 **Example 1:** 

```
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
```

 **Example 2:** 

```
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.
- 0 <= k <= nums.length

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 95.93%)  
**Memory:** 51.9 MB (beats 93.75%)  
**Submitted:** 2026-09-24T14:55:47.301Z  

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int c = 0, res = 0;
        int n = nums.length;
        int i = 0;

        for(int j=0; j<n; j++)
        {
            if(nums[j] == 0)
                c++;

            while(c > k)
            {
                if(nums[i] == 0)
                    c--;
                i++;
            }

            res = Math.max(res, j-i+1);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/max-consecutive-ones-iii/)