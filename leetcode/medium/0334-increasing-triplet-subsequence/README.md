# Increasing Triplet Subsequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, return `true` *if there exists a triple of indices* `(i, j, k)` *such that* `i < j < k` *and* `nums[i] < nums[j] < nums[k]`. If no such indices exists, return `false`.

 

 **Example 1:** 

```
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.

```

 **Example 2:** 

```
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.

```

 **Example 3:** 

```
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: One of the valid triplet is (1, 4, 5), because nums[1] == 1 < nums[4] == 4 < nums[5] == 6.

```

 

 **Constraints:** 

- 1 <= nums.length <= 5 * 105
- -231 <= nums[i] <= 231 - 1

 

 **Follow up:**  Could you implement a solution that runs in `O(n)` time complexity and `O(1)` space complexity?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 99.17%)  
**Memory:** 122.3 MB (beats 93.84%)  
**Submitted:** 2026-09-24T13:21:15.318Z  

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for(int num : nums)
        {
            if(num <= min1) min1 = num;
            else if(num <= min2) min2 = num;
            else return true;
        } 

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/increasing-triplet-subsequence/)