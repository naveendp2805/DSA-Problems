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
**Runtime:** 60 ms (beats 70.49%)  
**Memory:** 106.8 MB (beats 57.76%)  
**Submitted:** 2026-11-07T06:05:33.899Z  

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++)
        {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                int idx = stack.pop();
                res[idx] = i - idx;
            }

            stack.push(i);
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/largest-rectangle-in-histogram/)