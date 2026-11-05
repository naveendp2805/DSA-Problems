# Q3. Find All Numbers Disappeared in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array `nums` of `n` integers where `nums[i]` is in the range `[1, n]`, return  *an array of all the integers in the range*  `[1, n]`  *that do not appear in*  `nums`.

 

 **Example 1:** 

```
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

```

 **Example 2:** 

```
Input: nums = [1,1]
Output: [2]

```

 

 **Constraints:** 

- n == nums.length
- 1 <= n <= 105
- 1 <= nums[i] <= n

 

 **Follow up:**  Could you do it without extra space and in `O(n)` runtime? You may assume the returned list does not count as extra space.

## Solution

**Language:** Java  
**Runtime:** 21 ms (beats 21.67%)  
**Memory:** 73.9 MB (beats 29.09%)  
**Submitted:** 2026-11-05T15:53:24.699Z  

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for(int num : nums) {
            set.add(num);
        }

        for(int i=0; i<nums.length; i++)
        {
            if(!set.contains(i+1)) {
                res.add(i+1);
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)