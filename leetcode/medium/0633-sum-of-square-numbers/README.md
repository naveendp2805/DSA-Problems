# Q3. Sum of Square Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a non-negative integer `c`, decide whether there're two integers `a` and `b` such that `a2 + b2 = c`.

 

Original
Java
 **Example 1:** 

```
Input: c = 5
Output: true
Explanation: 1  *1 + 2*  2 = 5

```

 **Example 2:** 

```
Input: c = 3
Output: false

```

 

 **Constraints:** 

- 0 <= c <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 88.10%)  
**Memory:** 41.5 MB (beats 81.43%)  
**Submitted:** 2026-11-25T15:11:24.266Z  

```java
class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int) Math.sqrt(c);

        while(l <= r) {
            long sum = (long) l * l + (long) r * r;

            if(sum == c) {
                return true;
            } else if(sum < c) {
                l++;
            } else {
                r--;
            }
        }

        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-square-numbers/)