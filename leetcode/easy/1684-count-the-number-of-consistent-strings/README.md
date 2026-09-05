# Count the Number of Consistent Strings

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a string `allowed` consisting of  **distinct**  characters and an array of strings `words`. A string is  **consistent** if all characters in the string appear in the string `allowed`.

Return *the number of  **consistent**  strings in the array* `words`.

 

 **Example 1:** 

```
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

```

 **Example 2:** 

```
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

```

 **Example 3:** 

```
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.

```

 

 **Constraints:** 

- 1 <= words.length <= 104
- 1 <= allowed.length <= 26
- 1 <= words[i].length <= 10
- The characters in allowed are distinct.
- words[i] and allowed contain only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 91.42%)  
**Memory:** 47.9 MB (beats 19.87%)  
**Submitted:** 2026-09-05T15:53:17.342Z  

```java
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int allowedMask = 0;
        for(char ch : allowed.toCharArray())
            allowedMask |= 1 << (ch - 'a');

        for(String word : words)
        {
            int wordMask = 0;
            for(char ch : word.toCharArray())
                wordMask |= 1 << (ch - 'a');

            if((wordMask & allowedMask) == wordMask)
                res++;
        }

        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-the-number-of-consistent-strings/)