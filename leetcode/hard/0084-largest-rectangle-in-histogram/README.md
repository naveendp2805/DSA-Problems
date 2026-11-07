# Q3. Largest Rectangle in Histogram

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is `1`, return  *the area of the largest rectangle in the histogram*.

 

 **Example 1:** 

```
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

```

 **Example 2:** 

```
Input: heights = [2,4]
Output: 4

```

 

 **Constraints:** 

- 1 <= heights.length <= 105
- 0 <= heights[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 69 ms (beats 52.81%)  
**Memory:** 77.8 MB (beats 57.82%)  
**Submitted:** 2026-11-07T06:16:39.606Z  

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<=n; i++)
        {
            int currHeight = i == n ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currHeight)
            {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                int area = width * height;

                res = Math.max(res, area);
            }

            stack.push(i);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/largest-rectangle-in-histogram/)