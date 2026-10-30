# Summary Ranges

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a  **sorted unique**  integer array `nums`.

A  **range**  `[a,b]` is the set of all integers from `a` to `b` (inclusive).

Return  *the  **smallest sorted**  list of ranges that  **cover all the numbers in the array exactly***. That is, each element of `nums` is covered by exactly one of the ranges, and there is no integer `x` such that `x` is in one of the ranges but not in `nums`.

Each range `[a,b]` in the list should be output as:

- "a->b" if a != b
- "a" if a == b

 

 **Example 1:** 

```
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

```

 **Example 2:** 

```
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

```

 

 **Constraints:** 

- 0 <= nums.length <= 20
- -231 <= nums[i] <= 231 - 1
- All the values of nums are unique.
- nums is sorted in ascending order.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 93.95%)  
**Memory:** 44.6 MB (beats 7.39%)  
**Submitted:** 2026-10-30T07:59:52.928Z  

```java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int  n = nums.length;
        List<String> res = new ArrayList<>();

        if(n == 0) return res;
        
        int prev = nums[0], start = prev;

        for(int i=1; i<n; i++)
        {
            if(nums[i] - 1 != prev) {
                if(start == prev) {
                    res.add(String.valueOf(prev));
                } else {
                    res.add(String.valueOf(start) + "->" + String.valueOf(prev));
                }

                prev = start = nums[i];
            }
            else {
                prev = nums[i];
            }
        }

        if(start == prev) {
            res.add(String.valueOf(prev));
        } else {
            res.add(String.valueOf(start) + "->" + String.valueOf(prev));
        }
        
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/summary-ranges/)