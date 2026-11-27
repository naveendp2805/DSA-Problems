# Q2. 3Sum Closest

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` of length `n` and an integer `target`.

Find three integers at  **distinct indices**  in `nums` such that the sum is  **closest**  to `target`.

Return the sum of the three integers.

You may assume that each input would have  **exactly**  one solution.

 

Original
Java
 **Example 1:** 

```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

```

 **Example 2:** 

```
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

```

 

 **Constraints:** 

- 3 <= nums.length <= 500
- -1000 <= nums[i] <= 1000
- -104 <= target <= 104

## Solution

**Language:** Java  
**Runtime:** 18 ms (beats 51.83%)  
**Memory:** 45.2 MB (beats 43.58%)  
**Submitted:** 2026-11-27T05:39:35.534Z  

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        for(int i=0; i<n-2; i++) {
            int j = i+1;
            int k = n-1;

            while(j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if(Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }

                if(sum == target) return res;
                else if(sum < target) j++;
                else k--;
            }
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/3sum-closest/)