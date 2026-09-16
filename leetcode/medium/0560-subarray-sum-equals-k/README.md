# Subarray Sum Equals K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums` and an integer `k`, return  *the total number of subarrays whose sum equals to*  `k`.

A subarray is a contiguous  **non-empty**  sequence of elements within an array.

 

 **Example 1:** 

```
Input: nums = [1,1,1], k = 2
Output: 2

```

 **Example 2:** 

```
Input: nums = [1,2,3], k = 3
Output: 2

```

 

 **Constraints:** 

- 1 <= nums.length <= 2 * 104
- -1000 <= nums[i] <= 1000
- -107 <= k <= 107

## Solution

**Language:** Java  
**Runtime:** 23 ms (beats 92.96%)  
**Memory:** 49.1 MB (beats 12.25%)  
**Submitted:** 2026-09-16T10:53:15.841Z  

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<n; i++)
        {
            sum += nums[i];

            if(map.containsKey(sum - k))
                res += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarray-sum-equals-k/)