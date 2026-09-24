# Greatest Common Divisor of Strings

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

For two strings `s` and `t`, we say "`t` divides `s`" if and only if `s = t + t + t +... + t + t` (i.e., `t` is concatenated with itself one or more times).

Given two strings `str1` and `str2`, return  *the largest string* `x` *such that* `x` *divides both* `str1` *and* `str2`.

 

 **Example 1:** 

 **Input:**  str1 = "ABCABC", str2 = "ABC"

 **Output:**  "ABC"

 **Example 2:** 

 **Input:**  str1 = "ABABAB", str2 = "ABAB"

 **Output:**  "AB"

 **Example 3:** 

 **Input:**  str1 = "LEET", str2 = "CODE"

 **Output:**  ""

 **Example 4:** 

 **Input:**  str1 = "AAAAAB", str2 = "AAA"

 **Output:**  ""​​​​​​​

 

 **Constraints:** 

- 1 <= str1.length, str2.length <= 1000
- str1 and str2 consist of English uppercase letters.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 92.63%)  
**Memory:** 43.5 MB (beats 59.24%)  
**Submitted:** 2026-09-24T06:18:25.707Z  

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {

        if(!(str1 + str2).equals(str2 + str1))
            return "";

        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }

    private static int gcd(int n1, int n2)
    {
        while(n2 != 0)
        {
            int temp = n1 % n2;
            n1 = n2;
            n2 = temp;
        }

        return n1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/greatest-common-divisor-of-strings/)