# Subsets

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` of  **unique**  elements, return  *all possible*   *subsets*   *(the power set)*.

The solution set  **must not**  contain duplicate subsets. Return the solution in  **any order**.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [[],[0]]

```

 

 **Constraints:** 

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10
- All the numbers of nums are unique.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 87.21%)  
**Memory:** 44.2 MB (beats 57.27%)  
**Submitted:** 2026-09-23T14:56:16.000Z  

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        createSubset(nums, 0, res, subset);

        return res;
    }

    private static void createSubset(int[] nums, int idx, List<List<Integer>> res, List<Integer> subset)
    {
        if(idx == nums.length)
        {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        createSubset(nums, idx+1, res, subset);

        subset.remove(subset.size() - 1);
        createSubset(nums, idx+1, res, subset);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subsets/)