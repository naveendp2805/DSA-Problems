# Find the Index of the First Occurrence in a String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

 

 **Example 1:** 

```
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

```

 **Example 2:** 

```
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

```

 

 **Constraints:** 

- 1 <= haystack.length, needle.length <= 104
- haystack and needle consist of only lowercase English characters.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.8 MB (beats 76.27%)  
**Submitted:** 2026-10-23T05:31:43.184Z  

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle))
            return 0;

        int r = needle.length();

        for(int i=0; i<= haystack.length() - r; i++)
        {
            if(haystack.substring(i, i+r).equals(needle))
                return i;
        }

        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)