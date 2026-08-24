# Reverse Bits

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Reverse bits of a given 32 bits signed integer.

 

 **Example 1:** 

 **Input:**  n = 43261596

 **Output:**  964176192

 **Explanation:** 

Integer	Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000

 **Example 2:** 

 **Input:**  n = 2147483644

 **Output:**  1073741822

 **Explanation:** 

Integer	Binary
2147483644	01111111111111111111111111111100
1073741822	00111111111111111111111111111110

 

 **Constraints:** 

- 0 <= n <= 231 - 2
- n is even.

 

 **Follow up:**  If this function is called many times, how would you optimize it?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.2 MB (beats 93.09%)  
**Submitted:** 2026-08-24T09:31:31.478Z  

```java
class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for(int i=0; i<32; i++)
        {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-bits/)