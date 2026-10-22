# Trapping Rain Water

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

 

 **Example 1:** 

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

```

 **Example 2:** 

```
Input: height = [4,2,0,3,2,5]
Output: 9

```

 

 **Constraints:** 

- n == height.length
- 1 <= n <= 2 * 104
- 0 <= height[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 59.00%)  
**Memory:** 46.7 MB (beats 99.75%)  
**Submitted:** 2026-10-22T15:46:32.790Z  

```java
class Solution {
    public int trap(int[] height) {
        int l = 0, lmax = 0;
        int r = height.length - 1, rmax = 0;
        int water = 0;

        while(l <= r)
        {
            if(lmax <= rmax)
            {
                if(height[l] >= lmax)
                    lmax = height[l];
                else
                    water += lmax - height[l];

                l++;
            }
            else
            {
                if(height[r] >= rmax)
                    rmax = height[r];
                else
                    water += rmax - height[r];

                r--;
            }
        }

        return water;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/trapping-rain-water/)