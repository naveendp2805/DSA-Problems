# Q3. First Missing Positive

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an unsorted integer array `nums`. Return the  *smallest positive integer*  that is  *not present*  in `nums`.

You must implement an algorithm that runs in `O(n)` time and uses `O(1)` auxiliary space.

 

Original
Java
 **Example 1:** 

```
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

```

 **Example 2:** 

```
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

```

 **Example 3:** 

```
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -231 <= nums[i] <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 54.25%)  
**Memory:** 85.4 MB (beats 26.32%)  
**Submitted:** 2026-11-19T06:46:19.608Z  

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        while(i < n)
        {
            int correctIndex = nums[i] - 1;

            if(nums[i] >= 1 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for(i=0; i<n; i++) {
            if(i+1 != nums[i]) {
                return i+1;
            }
        }

        return n+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/first-missing-positive/)