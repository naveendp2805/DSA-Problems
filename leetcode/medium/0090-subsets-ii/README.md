# Subsets II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` that may contain duplicates, return  *all possible*   *subsets** (the power set)*.

The solution set  **must not**  contain duplicate subsets. Return the solution in  **any order**.

 

 **Example 1:** 

```
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

```

 **Example 2:** 

```
Input: nums = [0]
Output: [[],[0]]

```

 

 **Constraints:** 

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 99.73%)  
**Memory:** 45.1 MB (beats 42.03%)  
**Submitted:** 2026-09-23T15:06:30.237Z  

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);
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

        while(idx+1 < nums.length && nums[idx] == nums[idx+1])
            idx++;

        createSubset(nums, idx+1, res, subset);
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/subsets-ii/)