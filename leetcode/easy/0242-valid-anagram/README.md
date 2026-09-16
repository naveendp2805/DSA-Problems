# Valid Anagram

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  s = "anagram", t = "nagaram"

 **Output:**  true

 **Example 2:** 

 **Input:**  s = "rat", t = "car"

 **Output:**  false

 

 **Constraints:** 

- 1 <= s.length, t.length <= 5 * 104
- s and t consist of lowercase English letters.

 

 **Follow up:**  What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 99.64%)  
**Memory:** 44.7 MB (beats 55.92%)  
**Submitted:** 2026-09-16T13:29:37.581Z  

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq1 = countFreq(s);
        int[] freq2 = countFreq(t);

        return Arrays.equals(freq1, freq2);
    }

    private static int[] countFreq(String s)
    {
        int[] freq = new int[26];

        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        return freq;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/valid-anagram/)