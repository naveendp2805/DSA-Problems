# Complement of Base 10 Integer

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

The  **complement**  of an integer is the integer you get when you flip all the `0`'s to `1`'s and all the `1`'s to `0`'s in its binary representation.

- For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.

Given an integer `n`, return  *its complement*.

 

 **Example 1:** 

```
Input: n = 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.

```

 **Example 2:** 

```
Input: n = 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.

```

 **Example 3:** 

```
Input: n = 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.

```

 

 **Constraints:** 

- 0 <= n < 109

 

 **Note:**  This question is the same as 476: https://leetcode.com/problems/number-complement/

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.3 MB (beats 35.07%)  
**Submitted:** 2026-08-24T09:48:50.460Z  

```java
class Solution {
    public int bitwiseComplement(int num) {
        int res = 0, i=0;

        if(num == 0) return 1;

        while(num > 0)
        {
            if((num & 1) == 0)
                res += (int)Math.pow(2, i);

            num >>>= 1;
            i++;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/complement-of-base-10-integer/)