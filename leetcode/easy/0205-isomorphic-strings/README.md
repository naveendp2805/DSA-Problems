# Isomorphic Strings

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `s` and `t`,  *determine if they are isomorphic*.

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

 **Example 1:** 

 **Input:**  s = "egg", t = "add"

 **Output:**  true

 **Explanation:** 

The strings `s` and `t` can be made identical by:

- Mapping 'e' to 'a'.
- Mapping 'g' to 'd'.

 **Example 2:** 

 **Input:**  s = "f11", t = "b23"

 **Output:**  false

 **Explanation:** 

The strings `s` and `t` can not be made identical as `'1'` needs to be mapped to both `'2'` and `'3'`.

 **Example 3:** 

 **Input:**  s = "paper", t = "title"

 **Output:**  true

 

 **Constraints:** 

- 1 <= s.length <= 5 * 104
- t.length == s.length
- s and t consist of any valid ascii character.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 98.72%)  
**Memory:** 43.8 MB (beats 74.03%)  
**Submitted:** 2026-09-16T13:19:28.803Z  

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();

        int[] freqS = new int[128];
        int[] freqT = new int[128];

        for(int i=0; i<n; i++)
        {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(freqS[a] != 0 && freqS[a] != b)
                return false;
            
            if(freqT[b] != 0 && freqT[b] != a)
                return false;

            freqS[a] = b;
            freqT[b] = a;
        }

        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/isomorphic-strings/)