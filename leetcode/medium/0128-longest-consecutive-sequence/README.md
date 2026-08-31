# Longest Consecutive Sequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an unsorted array of integers `nums`, return  *the length of the longest consecutive elements sequence.* 

You must write an algorithm that runs in `O(n)` time.

 

 **Example 1:** 

```
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

```

 **Example 2:** 

```
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

```

 **Example 3:** 

```
Input: nums = [1,0,1,2]
Output: 3

```

 

 **Constraints:** 

- 0 <= nums.length <= 105
- -109 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 32 ms (beats 36.45%)  
**Memory:** 95.9 MB (beats 8.48%)  
**Submitted:** 2026-08-31T06:49:16.371Z  

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums)
            set.add(num);

        int res = 0;

        for(int num : set)
        {
            if(!set.contains(num - 1))
            {
                int len = 1;

                while(set.contains(num + len))
                    len++;

                res = Math.max(res, len);
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-consecutive-sequence/)