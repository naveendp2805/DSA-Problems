# Binary Number with Alternating Bits

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 

 **Example 1:** 

```
Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101

```

 **Example 2:** 

```
Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
```

 **Example 3:** 

```
Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.
```

 

 **Constraints:** 

- 1 <= n <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.3 MB (beats 36.51%)  
**Submitted:** 2026-08-24T09:41:43.663Z  

```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        int prevBit = (n & 1);
        n >>>= 1;

        while(n > 0)
        {
            int currBit = (n & 1);

            if(prevBit == currBit) return false;

            prevBit = currBit;

            n >>>= 1;
        }

        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-number-with-alternating-bits/)